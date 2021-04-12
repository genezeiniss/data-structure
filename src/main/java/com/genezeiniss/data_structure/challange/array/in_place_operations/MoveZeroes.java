package com.genezeiniss.data_structure.challange.array.in_place_operations;

import java.util.List;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 */
public class MoveZeroes {

    public static void moveZeroes(List<Integer> nums) {

        if (nums.size() > 1) {

            int writePointer = 0;
            int numOfZeros = 0;

            // Go through each element in the Array.
            for (int readPointer = 0; readPointer < nums.size(); readPointer++) {

                // If the current element we're reading is 0
                if (nums.get(readPointer) != 0) {
                    // Copy it into the next position at the front, tracked by writePointer.
                    nums.set(writePointer, nums.get(readPointer));
                    // And we need to now increment writePointer, because the next element
                    // should be written one space over.
                    writePointer++;
                } else {
                    // count zeros
                    numOfZeros++;
                }
            }

            // push all zeros to the end of array
            int lastIndex = nums.size() - 1;
            while (numOfZeros != 0) {
                nums.set(lastIndex, 0);
                numOfZeros--;
                lastIndex--;
            }
        }
    }
}
