package com.genezeiniss.data_structure.challange.array

import spock.lang.Specification
import spock.lang.Unroll

class DuplicateZerosSpec extends Specification {

    @Unroll
    def "duplicate zeros"() {
        given: "array"
        def array = input

        when: "duplicate zeros method is called"
        DuplicateZeros.duplicateZeros(array)

        then: "zeros in original array expected to be duplicated"
        assert array == expectedArray

        where:
        input                    || expectedArray
        [0, 0, 0, 0, 0, 0]       || [0, 0, 0, 0, 0, 0]
        [0, 0, 0, 0, 0, 1]       || [0, 0, 0, 0, 0, 0]
        [1, 2, 3, 0, 0, 0]       || [1, 2, 3, 0, 0, 0]
        [1, 0, 2, 3, 0, 4, 5, 0] || [1, 0, 0, 2, 3, 0, 0, 4]
        [8, 4, 5, 0, 0, 0, 0, 7] || [8, 4, 5, 0, 0, 0, 0, 0]
    }
}
