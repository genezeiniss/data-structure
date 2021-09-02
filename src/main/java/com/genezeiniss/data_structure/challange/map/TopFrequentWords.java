package com.genezeiniss.data_structure.challange.map;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given a review body, return the k most frequent elements.
 * Your answer should be sorted by frequency from highest to lowest.
 * If two words have the same frequency, then the word with the lower alphabetical order comes first.
 * <p>
 * Input: review text below, k = 4
 * Output: [“the”, “i”, “graphic”, “great”]
 * Explanation: “the”, “i”, “graphic” and “great” are the four most frequent words,
 * with the number of occurrences being 5, 3, 2 and 2 respectively.
 * Note that "graphic" comes before "great" due to a lower alphabetical order.
 */
public class TopFrequentWords {

    public static List<String> topKFrequent(String words, int k) {

        List<String> wordsList = splitStringToWords(words);

        // HashMap:
        // 1. HashMap doesn't guarantee any order.
        // 2. HashMap can contain duplicate values by not duplicate keys.
        Map<String, Long> wordCountHashMap = wordsList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // TreeMap sorts HashMap by key and it's keep entries in specific order
        Set<Map.Entry<String, Long>> sortedByKeyEntrySet = new TreeMap<>(wordCountHashMap).entrySet();
        return sortByValue(sortedByKeyEntrySet).stream()
                .limit(k)
                .collect(Collectors.toList());
    }

    private static List<String> splitStringToWords(String words) {
        return Arrays.stream(words.replaceAll("[^a-zA-Z0-9]", " ")
                .toLowerCase().trim().split(" "))
                .filter(word -> word != null && !word.isEmpty())
                .collect(Collectors.toList());
    }

    // sorted entry set by key cam be sorted by value now.
    // collect sorted stream to linked hash set (or map) to keep specific order.
    public static Set<String> sortByValue(Set<Map.Entry<String, Long>> entrySet) {
        return entrySet.stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
