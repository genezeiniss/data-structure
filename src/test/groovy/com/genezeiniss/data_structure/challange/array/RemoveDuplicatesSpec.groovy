package com.genezeiniss.data_structure.challange.array

import spock.lang.Specification
import spock.lang.Unroll

class RemoveDuplicatesSpec extends Specification {

    @Unroll
    def "remove duplicates"() {
        when:
        def length = RemoveDuplicates.removeDuplicates(input)

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
