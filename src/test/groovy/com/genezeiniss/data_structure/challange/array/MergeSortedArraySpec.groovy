package com.genezeiniss.data_structure.challange.array

import spock.lang.Specification
import spock.lang.Unroll

class MergeSortedArraySpec extends Specification {

    @Unroll
    def "merge"() {
        given: "arrays"
        def first = firstArray
        def second = secondArray

        when: "merge method is called"
        MergeSortedArray.merge(first, elementsInFirst, second, elementsInSecond)

        then: "two arrays expected to be merged and sorted"
        assert first == expectedSortedArray

        where:
        firstArray            | elementsInFirst | secondArray   | elementsInSecond || expectedSortedArray
        [1, 2, 3, 0, 0, 0]    | 3               | [2, 5, 6]     | 3                || [1, 2, 2, 3, 5, 6]
        [1]                   | 1               | []            | 0                || [1]
        [0, 1, 2, 3, 0, 0, 0] | 4               | [0, 1, 4]     | 3                || [0, 0, 1, 1, 2, 3, 4]
        [1, 2, 0, 0, 0, 0]    | 2               | [3, 8, 9, 10] | 4                || [1, 2, 3, 8, 9, 10]
    }
}
