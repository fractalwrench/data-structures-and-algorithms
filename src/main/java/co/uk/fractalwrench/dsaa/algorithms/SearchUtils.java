package co.uk.fractalwrench.dsaa.algorithms;

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
}
