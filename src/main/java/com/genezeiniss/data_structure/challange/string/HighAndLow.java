package com.genezeiniss.data_structure.challange.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HighAndLow {

    public static String highAndLow(String numbers) {
        List<Integer> sortedList =
                Arrays.stream(numbers.split(" "))
                        .map(Integer::valueOf)
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList());

        return String.format("%s %s", sortedList.get(0), sortedList.get(sortedList.size() - 1));
    }

    public static void main(String[] args) {
        System.out.println(highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }
}
