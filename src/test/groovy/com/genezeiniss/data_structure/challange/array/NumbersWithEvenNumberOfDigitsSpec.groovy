package com.genezeiniss.data_structure.challange.array

import spock.lang.Specification
import spock.lang.Unroll

class NumbersWithEvenNumberOfDigitsSpec extends Specification {

    @Unroll
    def "find numbers"() {
        when:
        def evenNumbers = NumbersWithEvenNumberOfDigits.findNumbers(input)

        then:
        assert evenNumbers == expectedOutput

        where:
        input                            || expectedOutput
        [12, 345, 2, 6, 7896]            || 2
        [555, 901, 482, 1771]            || 1
        [1, 22, 555, 901, 482, 17, 1771] || 3
    }
}
