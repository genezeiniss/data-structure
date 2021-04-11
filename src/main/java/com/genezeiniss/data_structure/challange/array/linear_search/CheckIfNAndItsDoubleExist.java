package com.genezeiniss.data_structure.challange.array.linear_search;

import java.util.List;

/**
 * Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
 * More formally check if there exists two indices i and j such that :
 * <p>
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 */
public class CheckIfNAndItsDoubleExist {

    public static boolean checkIfExist(List<Integer> arr) {

        if (arr != null && arr.size() > 1) {

            // On each step of the loop check if we have seen so far:
            // the element 2 * arr[i]
            // or the element arr[i] / 2 ( remember to check: arr[i] % 2 == 0)

            for (int i = 0; i < arr.size(); i++) {

                for (int j = (i - 1); j >= 0; j--) {

                    if (arr.get(i) == 2 * arr.get(j)) {
                        return true;
                    }

                    if (arr.get(i) == arr.get(j) / 2 && arr.get(j) % 2 == 0) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
