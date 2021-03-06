package co.uk.fractalwrench.dsaa.algorithms;

import co.uk.fractalwrench.dsaa.structures.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Function;

public class SearchUtils {

    /**
     * Performs a binary search on a sorted array of integers, to find the given element. A binary search
     * works by finding the element at the midpoint and checks whether it is greater than or less than
     * the required element. The array is then repeatedly bisected based on this result until the index is found.
     *
     * @param sortedArray a sorted array of integers, in ascending order
     * @param element     the element for which the index should be found
     * @return the index of the element, or -1 if it could not be found in the array
     */
    public static int binarySearch(int[] sortedArray, int element) {
        if (sortedArray.length == 0) {
            return -1;
        }

        // 1. start search parameters at the zeroth and last element
        int low = 0;
        int high = sortedArray.length;

        while (low <= high) {
            // 2. get the midpoint between the low and high point
            int mid = (high + low) / 2;

            // 3. if the midpoints equals the expected element return its index, otherwise
            // bisect the array again.
            if (sortedArray[mid] == element) {
                return mid;
            } else if (sortedArray[mid] >= element) { // too high
                high = mid - 1;
            } else if (sortedArray[mid] < element) { // too low
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * Performs a breadth-first-search on the TreeNode, which iterates over all neighbouring nodes before
     * descending the search to the child nodes. A callback is invoked for each Node.
     * <p>
     * This function assumes that the structure is a Tree and does not attempt to handle cyclic relationships.
     *
     * @param root     the root of the tree
     * @param callback a custom callback to respond to each Node.
     * @param <T>      the data type contained by the tree
     */
    public static <T> void breadthFirstSearch(TreeNode<T> root, Function<T, Void> callback) {
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<T> current = queue.poll();
            callback.apply(current.getData());
            queue.addAll(current.getChildren());
        }
    }

    /**
     * Performs a depth-first-search on the TreeNode, which exhausts all the nodes on a given branch before moving to
     * neighbouring nodes. A callback is invoked for each Node.
     * <p>
     * This function assumes that the structure is a Tree and does not attempt to handle cyclic relationships.
     *
     * @param root     the root of the tree
     * @param callback a custom callback to respond to each Node.
     * @param <T>      the data type contained by the tree
     */
    public static <T> void depthFirstSearch(TreeNode<T> root, Function<T, Void> callback) {
        callback.apply(root.getData());

        for (TreeNode<T> child : root.getChildren()) {
            depthFirstSearch(child, callback);
        }
    }

    /**
     * Performs a selection sort in-place on a given array.
     * <p></p>
     * Selection sort iterates over the whole array and finds the
     * smallest element, then swaps it with the front element. It iterates up the array until everything
     * has been sorted.
     * <p></p>
     * This approach has a worst case of O(n^2).
     *
     * @param elements the elements to sort in place.
     */
    public static void selectionSort(int[] elements) {
        // 1. iterate along array until every element has been sorted
        for (int k = 0; k < elements.length; k++) {
            int smallestIndex = k;

            // 2. find the minimum value in the subsection of the array, record its index
            for (int j = k + 1; j < elements.length; j++) {
                if (elements[j] < elements[smallestIndex]) {
                    smallestIndex = j;
                }
            }

            // 3. swap the minimum value to the front
            int tmp = elements[k];
            elements[k] = elements[smallestIndex];
            elements[smallestIndex] = tmp;
        }
    }

    /**
     * Performs a bubble sort in-place on a given array.
     * <p></p>
     * Bubble sort iterates over the array in a bubble, swapping the adjacent elements if the LHS is greater
     * than the RHS. It continues to iterate up the array in the bubble until everything
     * has been sorted.
     * <p></p>
     * This approach has a worst case of O(n^2).
     *
     * @param elements the elements to sort in place.
     */
    public static void bubbleSort(int[] elements) {
        // 1. iterate along the array until every element has been sorted
        for (int a = 0; a < elements.length; a++) {
            for (int b = a + 1; b < elements.length; b++) {
                int lhs = elements[a];
                int rhs = elements[b];

                // 2. swap the LHS of the bubble if the RHS is greater
                if (lhs > rhs) {
                    elements[a] = rhs;
                    elements[b] = lhs;
                }
            }
        }
    }

    /**
     * Radix sort exploits the fact that integers have a finite number of bits. The array is iterated over
     * multiple times, and each time the elements are grouped by each digit until the whole array is sorted.
     * <p></p>
     * Radix sort runs in O(kn) time, where k is the number of algorithm passes.
     *
     * @param elements the elements to sort in place
     */
    public static void radixSort(int[] elements) {
        if (elements.length < 2) {
            return;
        }

        // 1. find the maximum value in the array
        int maxValue = findMaxInt(elements);
        int maxDigits = countDigits(maxValue);
        int place = 1;

        // 2. compare each digit, starting from the least significant to the most significant.
        while (maxDigits-- > 0) {
            radixSort(elements, place);
            place *= 10;
        }
    }

    private static void radixSort(int[] elements, int place) {
        // 1. prepare array to track frequency and for copying elements
        int radix = 10;
        int[] copy = new int[elements.length];
        int[] freq = new int[radix];

        // 2. calculate frequency of least significant digits
        for (int k = 0; k < elements.length; k++) {
            int digit = (elements[k] / place) % radix;
            freq[digit]++;
        }

        for (int k = 1; k < radix; k++) {
            freq[k] += freq[k - 1];
        }

        // 2. copy the smallest element to LHS of copy array
        for (int k = elements.length - 1; k >= 0; k--) {
            int digit = (elements[k] / place) % radix;
            copy[freq[digit] - 1] = elements[k];
            freq[digit]--;
        }

        // 3. copy everything back into original array
        for (int k = 0; k < elements.length; k++) {
            elements[k] = copy[k];
        }
    }

    private static int findMaxInt(int[] elements) {
        return Arrays.stream(elements).max().getAsInt();
    }

    private static int countDigits(int value) {
        return (int) Math.log10(value) + 1;
    }

    /**
     * Performs a merge sort in-place on a given array.
     * <p></p>
     * Merge sort recursively splits the array into two halves, sorts each half separately, and then
     * combines the arrays together. This has an O(n log(n)) runtime making it one of the better sorting
     * algorithms.
     * <p></p>
     *
     * @param elements the elements to sort in place.
     */
    public static void mergeSort(int[] elements) {
        int[] helper = new int[elements.length];
        mergeSort(elements, helper, 0, elements.length - 1);
    }

    private static void mergeSort(int[] elements, int[] helper, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(elements, helper, low, mid); // sort the left half
            mergeSort(elements, helper, mid + 1, high); // sort the right half
            merge(elements, helper, low, mid, high); // combine the two halves
        }
    }

    private static void merge(int[] elements, int[] copy, int low, int mid, int high) {
        // 1. copy the elements into the helper array
        for (int k = low; k <= high; k++) {
            copy[k] = elements[k];
        }

        int lhs = low;
        int rhs = mid + 1;
        int curr = low;

        // 2. iterate over the two array halves and copy the smallest elements into the original array
        while (lhs <= mid && rhs <= high) {
            if (copy[lhs] <= copy[rhs]) {
                elements[curr] = copy[lhs];
                lhs++;
            } else {
                elements[curr] = copy[rhs];
                rhs++;
            }
            curr++;
        }

        // 2. copy the remaining helper array back into elements
        int remaining = mid - lhs;
        for (int k = 0; k <= remaining; k++) {
            elements[curr + k] = copy[lhs + k];
        }
    }
}
