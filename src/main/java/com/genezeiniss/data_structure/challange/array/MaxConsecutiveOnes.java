package com.genezeiniss.data_structure.challange.array;

import java.util.List;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * Notes:
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 */
public class MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(List<Integer> numbers) {

        int previousMaxNumber = 0;
        int maxNumber = 0;

        for (int number : numbers) {

            if (number == 1) {
                maxNumber += 1;
            } else {
                if (maxNumber > previousMaxNumber) {
                    previousMaxNumber = maxNumber;
                }
                maxNumber = 0;
            }
        }

        return Math.max(maxNumber, previousMaxNumber);
    }
}
