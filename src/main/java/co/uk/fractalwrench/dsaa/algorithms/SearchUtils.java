package co.uk.fractalwrench.dsaa.algorithms;

import co.uk.fractalwrench.dsaa.structures.TreeNode;

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

        for (TreeNode<T> child: root.getChildren()) {
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
}
