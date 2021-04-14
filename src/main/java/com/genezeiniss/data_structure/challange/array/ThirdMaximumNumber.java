package com.genezeiniss.data_structure.challange.array;

import com.genezeiniss.data_structure.challange.array.deletion.RemoveDuplicatesFromSortedArray;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Given integer array nums, return the third maximum number in this array. If the third maximum does not exist, return the maximum number.
 * <p>
 * Constraints:
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 */
public class ThirdMaximumNumber {

    public static int thirdMax(List<Integer> nums) {

        // sort array and remove duplicates
        nums = nums.stream().sorted().collect(Collectors.toList());
        int length = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);

        int count = 3;

        // if length is 1 --> return the value
        if (length == 1) {
            return nums.get(0);
        }

        // if length is 2 --> return max value
        if (length == 2) {
            return Math.max(nums.get(0), nums.get(1));
        }

        return nums.get(length - count);
    }
}
