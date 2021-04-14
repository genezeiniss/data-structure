package com.genezeiniss.data_structure.challange.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 * <p>
 * Constraints:
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 */
public class FindAllDisappearedNumbers {


    public static List<Integer> findDisappearedNumbers(List<Integer> nums) {

        nums = nums.stream().sorted().collect(Collectors.toList());

        int expected = 1;
        int lastExpected = nums.size();

        // create new list for disappeared values
        List<Integer> disappears = new ArrayList<>();
        int index = 0;

        while (expected <= lastExpected) {

            boolean expectedFound = false;

            for (int i = index; i < nums.size(); i++) {

                if (nums.get(i) == expected) {
                    expectedFound = true;
                    index = i;
                    break;
                }
            }

            if (!expectedFound) {
                disappears.add(expected);
            }

            expected++;
        }

        return disappears;
    }
}
