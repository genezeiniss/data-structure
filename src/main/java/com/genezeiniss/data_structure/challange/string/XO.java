package com.genezeiniss.data_structure.challange.string;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class XO {

    public static boolean getXO(String str) {
        Map<Character, Long> map = str.chars()
                .map(Character::toUpperCase)
                .mapToObj(character -> (char) character)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return Optional.ofNullable(map.get('X')).orElse((long) 0)
                .equals(Optional.ofNullable(map.get('O')).orElse((long) 0));
    }

    public static void main(String[] args) {
        System.out.println(getXO("zssddd"));
    }
}
