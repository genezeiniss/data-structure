package com.genezeiniss.data_structure.challange.array.deletion

import spock.lang.Specification
import spock.lang.Unroll

class RemoveDuplicatesFromSortedArraySpec extends Specification {

    @Unroll
    def "remove duplicates"() {
        when:
        def length = RemoveDuplicatesFromSortedArray.removeDuplicates(input)

        then:
        assert length == expectedLength
        assert input.subList(0, expectedLength) == expectedArray

        where:
        input                          || expectedLength | expectedArray
        [2, 2, 3, 3, 3]                || 2              | [2, 3]
        [0, 1, 2, 2, 3, 4, 5, 5]       || 6              | [0, 1, 2, 3, 4, 5]
        [0, 0, 1, 1, 1, 2, 2, 3, 3, 4] || 5              | [0, 1, 2, 3, 4]
    }

    @Unroll
    def "remove duplicates - one loop solution"() {
        when:
        def length = RemoveDuplicatesFromSortedArray.removeDuplicates_oneLoopSolution(input)

        then:
        assert length == expectedLength
        assert input.subList(0, expectedLength) == expectedArray

        where:
        input                          || expectedLength | expectedArray
        [2, 2, 3, 3, 3]                || 2              | [2, 3]
        [0, 1, 2, 2, 3, 4, 5, 5]       || 6              | [0, 1, 2, 3, 4, 5]
        [0, 0, 1, 1, 1, 2, 2, 3, 3, 4] || 5              | [0, 1, 2, 3, 4]
    }
}
