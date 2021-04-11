package com.genezeiniss.data_structure.challange.array.linear_search;

import java.util.List;

/**
 * Given an array of integers arr, return true if and only if it is a valid mountain array.
 * Recall that arr is a mountain array if and only if:
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr.get(i)
 * arr.get(i) > arr[i + 1] > ... > arr[arr.length - 1]
 */
public class ValidMountainArray {

    public static boolean validMountainArray(List<Integer> arr) {

        if (arr.size() < 3) {
            return false;
        }

        // find highest element of the array
        int highestIndex = 0;
        for (int i = 1; i < arr.size(); i++) {

            // valid mountain array should not include equal values
            if (arr.get(i).equals(arr.get(highestIndex))) {
                return false;
            }

            if (arr.get(i) > arr.get(highestIndex)) {
                highestIndex = i;
            }
        }

        // if highest index is boundary index - return array is not valid mountain
        if (highestIndex == 0 || highestIndex == arr.size() - 1) {
            return false;
        }

        // check that values from the left of highestIndex are in increasing order
        int previousIndex = 0;
        for (int j = 1; j < highestIndex; j++) {
            if (arr.get(previousIndex) < arr.get(j)) {
                previousIndex++;
            } else {
                return false;
            }
        }

        // check that values from the right of highestIndex are in decreasing order
        previousIndex = highestIndex;
        for (int k = highestIndex + 1; k < arr.size(); k++) {
            if (arr.get(previousIndex) > arr.get(k)) {
                previousIndex++;
            } else {
                return false;
            }
        }

        return true;
    }

    public static boolean validMountainArray_additionalSolution(List<Integer> arr) {

        int index = 0;

        // walk up
        while (index + 1 < arr.size() && arr.get(index) < arr.get(index + 1)) {
            index++;
        }

        // peak can't be first or last
        if (index == 0 || index == arr.size() - 1) {
            return false;
        }

        // walk down
        while (index + 1 < arr.size() && arr.get(index) > arr.get(index + 1)) {
            index++;
        }

        return index == arr.size() - 1;
    }
}
