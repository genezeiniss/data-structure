package com.genezeiniss.data_structure.challange.array.deletion;

import java.util.List;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Constraints:
 * 0 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums is sorted in ascending order.
 */
public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(List<Integer> nums) {

        int length = nums.size();

        if (length > 0) {

            // start counting from index 1, to compare it with the previous number
            for (int i = 1; i < length; i++) {

                while (nums.get(i).equals(nums.get(i - 1)) && i < length) {

                    for (int j = i; j < (length - 1); j++) {
                        nums.set(j, nums.get(j + 1));
                    }

                    length--;
                }
            }
        }

        return length;
    }

    /**
     * Since the array is already sorted, we can keep two pointers i and j,
     * where i is the slow-runner while j is the fast-runner.
     * As long as nums[i] == nums[j], we increment j to skip the duplicate.
     * <p>
     * When we encounter nums[j] = nums[i], the duplicate run has ended so we must copy its value to nums[i+1].
     * i is then incremented and we repeat the same process again until j reaches the end of array.
     */
    public static int removeDuplicates_oneLoopSolution(List<Integer> nums) {

        if (nums.size() == 0) {
            return 0;
        }

        // Use the two pointer technique to remove the duplicates in-place.
        // The first element shouldn't be touched; it's already in its correct place.
        int writePointer = 1;

        // Go through each element in the Array.
        for (int readPointer = 1; readPointer < nums.size(); readPointer++) {

            // If the current element we're reading is *different* to the previous
            // element...
            if (!nums.get(readPointer).equals(nums.get(writePointer - 1))) {
                // Copy it into the next position at the front, tracked by writePointer.
                nums.set(writePointer, nums.get(readPointer));
                // And we need to now increment writePointer, because the next element
                // should be written one space over.
                writePointer++;
            }
        }
        return writePointer;
    }
}
