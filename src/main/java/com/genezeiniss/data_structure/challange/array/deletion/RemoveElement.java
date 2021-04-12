package com.genezeiniss.data_structure.challange.array.deletion;

import java.util.List;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {

    public static int removeElement_mySolution(List<Integer> nums, int val) {

        int length = nums.size();

        for (int i = 0; i < length; i++) {

            while (nums.get(i) == val && i < length) {

                for (int j = i + 1; j < length; j++) {
                    nums.set(j - 1, nums.get(j));
                }

                length--;
            }
        }

        return length;
    }

    public static int removeElement_firstApproach(List<Integer> nums, int val) {

        int i = 0;
        int length = nums.size();

        while (i < length) {

            if (nums.get(i) == val) {
                nums.set(i, nums.get(length - 1));
                // reduce array size by one
                length--;
            } else {
                i++;
            }
        }
        return length;
    }

    public static int removeElement_secondApproach(List<Integer> nums, int val) {

        int writePointer = 0;

        for (int readPointer = 0; readPointer < nums.size(); readPointer++) {
            if (nums.get(readPointer) != val) {
                nums.set(writePointer, nums.get(readPointer));
                writePointer++;
            }
        }
        return writePointer;
    }
}
