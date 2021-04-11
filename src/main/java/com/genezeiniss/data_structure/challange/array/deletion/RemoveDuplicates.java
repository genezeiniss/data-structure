package com.genezeiniss.data_structure.challange.array.deletion;

import java.util.List;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */
public class RemoveDuplicates {

    public static int removeDuplicates(List<Integer> nums) {

        int length = nums.size();

        // start counting from index 1, to compare it with the previous number
        for (int i = 1; i < length; i++) {

            while (nums.get(i).equals(nums.get(i - 1)) && i < length) {

                for (int j = i; j < (length - 1); j++) {
                    nums.set(j, nums.get(j + 1));
                }

                length--;
            }
        }

        return length;
    }
}
