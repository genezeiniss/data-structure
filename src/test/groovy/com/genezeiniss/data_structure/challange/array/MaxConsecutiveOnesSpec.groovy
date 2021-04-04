package com.genezeiniss.data_structure.challange.array

import spock.lang.Specification
import spock.lang.Unroll

class MaxConsecutiveOnesSpec extends Specification {

    @Unroll
    def "find max consecutive ones"() {
        when:
        def consecutiveOnesNum = MaxConsecutiveOnes.findMaxConsecutiveOnes(input)

        then:
        assert consecutiveOnesNum == expectedOutput

        where:
        input                                      || expectedOutput
        [1, 0, 1, 1, 0, 1]                         || 2
        [1, 1, 0, 0, 0, 1, 1, 1, 0]                || 3
        [0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0] || 4
    }
}
