package com.genezeiniss.data_structure.algorithm.search;

import java.util.List;

public class BinarySearch {

    /**
     * returns the index position of a target if found, else returns -1.
     * note: the values in the list must be sorted in ascending order!
     * <p>
     * current implementation:
     * we are pointing to the different sections of the original list (without to create a sub-list).
     * it means, that search complexity is constant (it takes constant space of size n - O(1)), since
     * the amount of storage required for this algorithm doesn't effected by target value position. it's always equal to number of original list elements.
     */
    public static int iterativeSearchForNumber(List<Integer> searchRange, int target) {

        int firstIndex = 0;
        int lastIndex = searchRange.size() - 1;

        while (firstIndex <= lastIndex) {
            int midIndex = (firstIndex + lastIndex) / 2;

            if (searchRange.get(midIndex) == target) {
                return midIndex;
            } else if (searchRange.get(midIndex) < target) {
                firstIndex = midIndex + 1;
            } else {
                lastIndex = midIndex - 1;
            }
        }

        return -1;
    }

    public static int iterativeSearchForString(List<String> searchRange, String target) {

        int firstIndex = 0;
        int lastIndex = searchRange.size() - 1;

        while (firstIndex <= lastIndex) {
            int midIndex = (firstIndex + lastIndex) / 2;

            if (searchRange.get(midIndex).equals(target)) {
                return midIndex;
            } else if (searchRange.get(midIndex).compareTo(target) < 0) {
                firstIndex = midIndex + 1;
            } else {
                lastIndex = midIndex - 1;
            }
        }

        return -1;
    }

    /**
     * returns true if target is found in the provided list, else returns false.
     * note: the return value is boolean and not int since the algorithm is running on sub-lists, which shuffles the indexes of the values.
     * <p>
     * current implementation:
     * the new sub list is created (from original list), each time the recursive function is called.
     * it means, that we allocating additional memory of size n/2, n/4 and so on for each recursive call,
     * until we have a sub-list that is empty, or contain the single value.
     */
    public static boolean recursiveSearchForNumber(List<Integer> searchRange, int target) {

        if (!searchRange.isEmpty()) {

            int midPoint = searchRange.size() / 2;

            if (searchRange.get(midPoint) == target) {
                return true;
            } else if (searchRange.get(midPoint) < target) {
                // call to same function with the shortest list: from the midpoint to the end
                return recursiveSearchForNumber(searchRange.subList(midPoint + 1, searchRange.size()), target);
            } else {
                // call to same function with the shortest list: from the start up to the midpoint
                return recursiveSearchForNumber(searchRange.subList(0, midPoint), target);
            }
        }

        return false;
    }
}