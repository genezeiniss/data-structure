package com.genezeiniss.data_structure.challange.array.in_place_operations;

import java.util.List;

/**
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
 * After doing so, return the array.
 * <p>
 * Constraints:
 * 1 <= arr.length <= 104
 * 1 <= arr[i] <= 105
 */
public class ReplaceElementsWithGreatestElementOnRightSide {

    public static List<Integer> replaceElements(List<Integer> arr) {

        // we don't run on the last element. it will be replaced by -1
        for (int currentIndex = 0; currentIndex < arr.size() - 1; currentIndex++) {

            // assume that greatest index is the next index
            int greatest = currentIndex + 1;

            // find the greatest element, by comparing other elements to assumed one
            for (int innerIndex = greatest + 1; innerIndex < arr.size(); innerIndex++) {

                if (arr.get(innerIndex) > arr.get(greatest)) {
                    greatest = innerIndex;
                }
            }

            arr.set(currentIndex, arr.get(greatest));
        }

        arr.set(arr.size() - 1, -1);
        return arr;
    }
}
