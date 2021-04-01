package com.genezeiniss.data_structure.sort_algorithm;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LinearSort {

    public static List<Integer> sortInAscendingOrder(List<Integer> list) {

        // empty or single element list is already sorted. it called "naive sort".
        if (list.size() > 1) {

            for (int index = 0; index < list.size(); index++) {
                int value = list.get(index);
                int previousIndex = index - 1;

                // if value in previous index is greater then current value
                while (previousIndex >= 0 && list.get(previousIndex) > value) {
                    list.set((previousIndex + 1), list.get(previousIndex));
                    previousIndex = (previousIndex - 1);
                }
                list.set((previousIndex + 1), value);
            }
        }
        return list;
    }
}
