package com.genezeiniss.data_structure.challange.array;

import java.util.List;

/**
 * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
 * Note that elements beyond the length of the original array are not written.
 * Do the above modifications to the input array in place, do not return anything from your function.
 * <p>
 * Notes:
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 */
public class DuplicateZeros {

    public static void duplicateZeros(List<Integer> array) {

        int possibleDuplicates = 0;
        int lastIndex = array.size() - 1;

        // find the number of zeros to be duplicated
        // stopping when left points beyond the last element in the original array
        // which would be part of the modified array
        for (int left = 0; left <= (lastIndex - possibleDuplicates); left++) {

            // count the zeros
            if (array.get(left) == 0) {

                // edge case: this zero can't be duplicated. We have no more space,
                // as left is pointing to the last element which could be included
                if (left == (lastIndex - possibleDuplicates)) {
                    // for this zero we just copy it without duplication.
                    array.set(lastIndex, 0);
                    lastIndex -= 1;
                    break;
                }
                possibleDuplicates++;
            }
        }

        // start backwards from the last element which would be part of new array.
        int reassignedLastIndex = lastIndex - possibleDuplicates;

        // run on the array from the right (reassigned last index) to the left and copy zero twice, and non zero once.
        for (int right = reassignedLastIndex; right >= 0; right--) {
            if (array.get(right) == 0) {
                array.set(right + possibleDuplicates, 0);
                possibleDuplicates--;
                array.set(right + possibleDuplicates, 0);
            } else {
                array.set(right + possibleDuplicates, array.get(right));
            }
        }

        System.out.println(array);
    }
}
