package com.genezeiniss.data_structure.algorithm.search;

import java.util.List;

public class LinearSearch {

    /**
     * returns the index position of a target if found, else returns -1.
     */
    public static int searchForNumber(List<Integer> searchRange, int target) {

        for (int i = 0; i < searchRange.size(); i++) {
            if (target == searchRange.get(i)) {
                return i;
            }
        }

        return -1;
    }
}