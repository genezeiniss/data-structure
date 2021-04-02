package com.genezeiniss.data_structure.sort_algorithm;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class RecursiveMergeSort {

    /**
     * implementation steps:
     * divide: find the midpoint of the list and divide into sub-lists.
     * conquer: recursively sort the sub-lists created in previous list.
     * combine: Merge the sorted sub-lists created in previous steps.
     */
    public static List<Integer> sortNumbers(List<Integer> numbers) {

        // empty or single element list is already sorted. it called "naive sort".
        if (numbers == null || numbers.size() <= 1) {
            return numbers;
        }

        List<List<Integer>> splitLists = splitAtMidpoint(numbers);
        List<Integer> leftHalfSorted = sortNumbers(splitLists.get(0));
        List<Integer> rightHalfSorted = sortNumbers(splitLists.get(1));
        return merge(leftHalfSorted, rightHalfSorted);
    }

    /**
     * divide the unsorted list at midpoint into sub-lists.
     * return list of left and right sub-lists.
     * <p>
     * note:
     * this split function is pretty expensive, because, by splitting the original list, we are creating two new lists, which allocating the memory.
     */
    private static List<List<Integer>> splitAtMidpoint(List<Integer> list) {

        int midIndex = (list.size() - 1) / 2;

        List<Integer> leftHalf = new ArrayList<>();
        List<Integer> rightHalf = new ArrayList<>();

        for (int index = 0; index < list.size(); index++) {

            if (index <= midIndex) {
                leftHalf.add(list.get(index));
            } else {
                rightHalf.add(list.get(index));
            }
        }

        return Arrays.asList(leftHalf, rightHalf);
    }

    /**
     * merges two lists (arrays), sorting them in the process.
     * returns merged list.
     */
    private static List<Integer> merge(List<Integer> leftList, List<Integer> rightList) {

        int leftIndex = 0;
        int rightIndex = 0;
        List<Integer> mergedList = new ArrayList<>();

        while (leftIndex < leftList.size() && rightIndex < rightList.size()) {

            if (leftList.get(leftIndex) < rightList.get(rightIndex)) {
                mergedList.add(leftList.get(leftIndex));
                leftIndex += 1;
            } else {
                mergedList.add(rightList.get(rightIndex));
                rightIndex += 1;
            }
        }

        while (leftIndex < leftList.size()) {
            mergedList.add(leftList.get(leftIndex));
            leftIndex += 1;
        }

        while (rightIndex < rightList.size()) {
            mergedList.add(rightList.get(rightIndex));
            rightIndex += 1;
        }
        return mergedList;
    }
}
