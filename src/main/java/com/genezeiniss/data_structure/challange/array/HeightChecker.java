package com.genezeiniss.data_structure.challange.array;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height.
 * Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.
 * You are given an integer array heights representing the current order that the students are standing in.
 * Each heights[i] is the height of the ith student in line (0-indexed).
 * Return the number of indices where heights[i] != expected[i].
 * <p>
 * Constraints:
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 */
public class HeightChecker {

    public static int heightChecker(List<Integer> heights) {

        int length = heights.size();

        if (length == 1) {
            return 0;
        }

        // create new array with expected heights (copy of sorted heights array)
        List<Integer> expected = heights.stream().sorted().collect(Collectors.toList());

        int mismatch = 0;
        for (int i = 0; i < length; i++) {
            if (!heights.get(i).equals(expected.get(i))) {
                mismatch++;
            }
        }

        return mismatch;
    }
}
