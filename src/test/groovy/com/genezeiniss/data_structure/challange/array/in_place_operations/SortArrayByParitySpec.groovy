package com.genezeiniss.data_structure.challange.array.in_place_operations

import spock.lang.Specification
import spock.lang.Unroll

class SortArrayByParitySpec extends Specification {

    @Unroll
    def "sort array by parity"() {
        when:
        SortArrayByParity.sort(input)

        then:
        assert input == expectedArray

        where:
        input              || expectedArray
        [3, 1, 2, 4]       || [2, 4, 3, 1]
        [1, 2, 0, 3, 0, 0] || [2, 0, 0, 0, 1, 3]
        [0]                || [0]
    }
}
