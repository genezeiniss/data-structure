package com.genezeiniss.data_structure.challange.string;

/**
 * A pangram is a sentence that contains every single letter of the alphabet at least once. For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least once (case is irrelevant).
 * Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers and punctuation.
 */
public class PangramChecker {

    public static boolean check(String sentence) {
        int englishAlphabetLength = 26;
        long distinctCharsLength = sentence.chars()
                .map(Character::toLowerCase)
                .filter(Character::isAlphabetic)
                .distinct().count();
        return distinctCharsLength == englishAlphabetLength;
    }

    public static void main(String[] args) {
        System.out.println(check("The, quick brown fox, jumps over the lazy dog"));
    }
}
