package com.genezeiniss.data_structure.challange.array.insert;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.
 * <p>
 * Constraints:
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 */
public class MergeSortedArray {

    /**
     * with additional array creation
     */
    public static void firstApproach(List<Integer> firstArray, int firstSize, List<Integer> secondArray, int secondSize) {

        int arrayCapacity = firstSize + secondSize;
        List<Integer> sortedList = new ArrayList<>(arrayCapacity);

        int firstArrayIndex = 0;
        int secondArrayIndex = 0;

        while (firstSize > 0 && secondSize > 0) {

            if (firstArray.get(firstArrayIndex) < secondArray.get(secondArrayIndex)) {
                sortedList.add(firstArray.get(firstArrayIndex));
                firstArrayIndex += 1;
                firstSize -= 1;
            } else if (firstArray.get(firstArrayIndex).equals(secondArray.get(secondArrayIndex))) {
                sortedList.add(firstArray.get(firstArrayIndex));
                firstArrayIndex += 1;
                firstSize -= 1;

                sortedList.add(secondArray.get(secondArrayIndex));
                secondArrayIndex += 1;
                secondSize -= 1;
            } else {
                sortedList.add(secondArray.get(secondArrayIndex));
                secondArrayIndex += 1;
                secondSize -= 1;
            }
        }

        if (firstSize == 0) {
            sortedList.addAll(secondArray.subList(secondArrayIndex, secondArray.size()));
        }

        if (secondSize == 0) {
            sortedList.addAll(firstArray.subList(firstArrayIndex, firstArray.size()));
        }

        for (int i = 0; i < sortedList.size(); i++) {
            firstArray.set(i, sortedList.get(i));
        }
        System.out.println(firstArray);
    }

    /**
     * without additional array creation
     */
    public static void secondApproach(List<Integer> first, int firstSize, List<Integer> second, int secondSize) {

        int firstIndex = firstSize - 1;
        int secondIndex = secondSize - 1;
        int index = first.size() - 1;

        while (index >= 0) {

            if (firstIndex < 0) {
                first.set(index, second.get(secondIndex--));

            } else if (secondIndex < 0) {
                first.set(index, first.get(firstIndex--));
            } else {
                if (first.get(firstIndex) > second.get(secondIndex)) {
                    first.set(index, first.get(firstIndex--));
                } else {
                    first.set(index, second.get(secondIndex--));
                }
            }

            index--;
        }

        System.out.println(first);
    }
}
