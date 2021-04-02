package com.genezeiniss.data_structure.sort_algorithm;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {

    /**
     * selection sort algorithm sorts an array by repeatedly finding the minimum element from unsorted part and putting it at the beginning.
     * the algorithm maintains two sub-lists in a given array.
     * 1. sub-list which is already sorted.
     * 2. remaining sub-list which is unsorted.
     * in every iteration of selection sort, the minimum element from the unsorted sub-list is picked and moved to the sorted subarray.
     */
    public static List<Integer> sortNumbers(List<Integer> numbers) {

        // naive sort
        if (numbers == null || numbers.size() <= 1) {
            return numbers;
        }

        int listSize = numbers.size();
        List<Integer> sortedList = new ArrayList<>();

        for (int index = 0; index < listSize; index++) {
            int indexToMove = getMinValueIndex(numbers);

            // move minimum element from unsorted list to sorted
            sortedList.add(numbers.get(indexToMove));
            numbers.remove(indexToMove);
        }

        System.out.printf("sorted list: %s%n", sortedList);
        return sortedList;
    }

    private static int getMinValueIndex(List<Integer> numbers) {

        int minValueIndex = 0;

        for (int index = 0; index < numbers.size(); index++) {
            if (numbers.get(index) < numbers.get(minValueIndex)) {
                minValueIndex = index;
            }
        }

        return minValueIndex;
    }
}
