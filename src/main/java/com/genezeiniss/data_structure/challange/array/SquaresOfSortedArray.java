package com.genezeiniss.data_structure.challange.array;

import com.genezeiniss.data_structure.algorithm.sort.LinearSort;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * Constraints:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 */
public class SquaresOfSortedArray {

    public static List<Integer> sortedSquares(List<Integer> numbers) {

        List<Integer> squares = new ArrayList<>(numbers.size());

        for (int i = 0; i < numbers.size(); i++) {
            int number = (numbers.get(i)) * (numbers.get(i));
            squares.add(i, number);
        }

        return LinearSort.sortNumbers(squares);
    }
}
