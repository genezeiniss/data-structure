package com.genezeiniss.data_structure.challange.array.linear_search

import spock.lang.Specification
import spock.lang.Unroll

class ValidMountainArraySpec extends Specification {

    @Unroll
    def "valid mountain array"() {
        when:
        def result = ValidMountainArray.validMountainArray(input)

        then:
        assert result == expectedResult

        where:
        input                    || expectedResult
        [2, 1]                   || false
        [3, 5, 5]                || false
        [0, 3, 2, 1]             || true
        [0, 2, 3, 4, 5, 2, 1, 0] || true
        [0, 2, 3, 3, 5, 2, 1, 0] || false
    }

    @Unroll
    def "valid mountain array - additional solution"() {
        when:
        def result = ValidMountainArray.validMountainArray_additionalSolution(input)

        then:
        assert result == expectedResult

        where:
        input                    || expectedResult
        [2, 1]                   || false
        [3, 5, 5]                || false
        [0, 3, 2, 1]             || true
        [0, 2, 3, 4, 5, 2, 1, 0] || true
        [0, 2, 3, 3, 5, 2, 1, 0] || false
    }
}
