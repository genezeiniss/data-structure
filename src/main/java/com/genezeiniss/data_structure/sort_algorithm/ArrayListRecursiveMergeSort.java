package com.genezeiniss.data_structure.sort_algorithm;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArrayListRecursiveMergeSort {

    /**
     * implementation steps:
     * Divide: find the midpoint of the list and divide into sub-lists.
     * Conquer: recursively sort the sub-lists created in previous list.
     * Combine: Merge the sorted sub-lists created in previous steps.
     */
    public static List<Integer> sortInAscendingOrder(List<Integer> list) {

        // empty or single element list is already sorted. it called "naive sort".
        if (list.size() <= 1) {
            return list;
        }

        List<List<Integer>> splitLists = split(list);
        List<Integer> leftHalfSorted = sortInAscendingOrder(splitLists.get(0));
        List<Integer> rightHalfSorted = sortInAscendingOrder(splitLists.get(1));
        return mergeWithAscendingSort(leftHalfSorted, rightHalfSorted);
    }

    /**
     * Divide the unsorted list at midpoint into sub-lists.
     * Return list of left and right sub-lists.
     * Note: this split function is pretty expensive, because, by splitting the original list, we are creating two new lists, which allocating the memory.
     */
    private static <T> List<List<T>> split(List<T> list) {

        int midIndex = (list.size() - 1) / 2;
        return new ArrayList<>(list.stream()
                .collect(Collectors.groupingBy(s -> list.indexOf(s) > midIndex))
                .values());
    }

    /**
     * Merges two lists (arrays), sorting them in the process.
     * Returns merged list.
     */
    private static List<Integer> mergeWithAscendingSort(List<Integer> leftList, List<Integer> rightList) {

        List<Integer> mergedList = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

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
