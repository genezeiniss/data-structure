package com.genezeiniss.data_structure.algorithm.sort;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuickSort {

    /**
     * sort numbers in ascending order.
     * return sorted numbers.
     * <p>
     * note:
     * this method to sort regular array list is faster then others (even faster then merge sort)
     * however, it uses more memory, because, by splitting the original list, we are creating two new lists, which allocating the memory.
     * <p>
     * implementation:
     * 1. get first number as a pivot (index 0)
     * 2. split other elements to two sub-lists:
     * * 2.1 less or equal than pivot
     * * 2.2 greater than pivot
     * 3. sort sort sub-lists by calling to 'sort numbers' function recursively.
     * 4. combine sorted lists with pivot and return: [less than pivot] + pivot + [greater than pivot]
     */
    public static List<Integer> sortNumbers(List<Integer> numbers) {

        // naive sort
        if (numbers == null || numbers.size() <= 1) {
            return numbers;
        }

        int pivot = numbers.get(0);
        List<Integer> lessThanPivot = new ArrayList<>();
        List<Integer> greaterThanPivot = new ArrayList<>();

        numbers.subList(1, numbers.size()).forEach(number -> {
            if (number <= pivot) {
                lessThanPivot.add(number);
            } else {
                greaterThanPivot.add(number);
            }
        });

        System.out.printf("%15s %1s %-15s%n", lessThanPivot, pivot, greaterThanPivot);

        List<Integer> sortedNumbers = new ArrayList<>(sortNumbers(lessThanPivot));
        sortedNumbers.add(pivot);
        sortedNumbers.addAll(sortNumbers(greaterThanPivot));
        return sortedNumbers;
    }
}