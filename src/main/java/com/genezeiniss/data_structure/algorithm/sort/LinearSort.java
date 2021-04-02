package com.genezeiniss.data_structure.algorithm.sort;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LinearSort {

    public static List<Integer> sortNumbers(List<Integer> numbers) {

        // empty or single element list is already sorted. it called "naive sort".
        if (numbers.size() > 1) {

            for (int index = 0; index < numbers.size(); index++) {
                int value = numbers.get(index);
                int previousIndex = index - 1;

                // if value in previous index is greater then current value
                while (previousIndex >= 0 && numbers.get(previousIndex) > value) {
                    numbers.set((previousIndex + 1), numbers.get(previousIndex));
                    previousIndex = (previousIndex - 1);
                }
                numbers.set((previousIndex + 1), value);
            }
        }
        return numbers;
    }
}
