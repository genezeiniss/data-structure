package com.genezeiniss.data_structure.challange.string;

public class MiddleCharacter {

    public static String getMiddle(String word) {
        int midIndex = (word.length() - 1) / 2;
        return word.length() % 2 == 0 ?
                String.format("%s%s", word.charAt(midIndex), word.charAt(midIndex + 1)) :
                String.valueOf(word.charAt(midIndex));
    }

    public static void main(String[] args) {
        System.out.println(getMiddle("tset"));
    }
}
