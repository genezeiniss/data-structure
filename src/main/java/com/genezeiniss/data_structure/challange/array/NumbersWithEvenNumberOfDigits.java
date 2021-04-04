package com.genezeiniss.data_structure.challange.array;

import java.util.List;

/**
 * Given an array nums of integers, return how many of them contain an even number of digits.
 * Constraints:
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 10^5
 */
public class NumbersWithEvenNumberOfDigits {

    public static int findNumbers(List<Integer> numbers) {

        int evenNums = 0;

        for (int number : numbers) {

            if (String.valueOf(number).length() % 2 == 0) {
                evenNums += 1;
            }
        }

        return evenNums;
    }
}
