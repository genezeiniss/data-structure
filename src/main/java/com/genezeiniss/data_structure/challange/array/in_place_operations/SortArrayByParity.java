package com.genezeiniss.data_structure.challange.array.in_place_operations;

import java.util.List;

/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 * You may return any answer array that satisfies this condition.
 * <p>
 * Constraints:
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */
public class SortArrayByParity {

    public static List<Integer> sort(List<Integer> nums) {

        if (nums.size() > 1) {

            for (int i = 0; i < nums.size(); i++) {

                int value = nums.get(i);

                // if value is odd -> find first even number and replace them
                if (value % 2 != 0) {

                    for (int j = i + 1; j < nums.size(); j++) {

                        if (nums.get(j) % 2 == 0) {
                            nums.set(i, nums.get(j));
                            nums.set(j, value);
                            break;
                        }
                    }
                }

            }
        }

        return nums;
    }
}
