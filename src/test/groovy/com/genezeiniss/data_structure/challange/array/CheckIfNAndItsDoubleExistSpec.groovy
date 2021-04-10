package com.genezeiniss.data_structure.challange.array

import spock.lang.Specification
import spock.lang.Unroll

class CheckIfNAndItsDoubleExistSpec extends Specification {

    @Unroll
    def "check if exist"() {
        when:
        def result = CheckIfNAndItsDoubleExist.checkIfExist(input)

        then:
        assert result == expectedResult

        where:
        input                      || expectedResult
        [10, 2, 5, 3]              || true
        [7, 1, 14, 11]             || true
        [3, 1, 7, 11]              || false
        [-2, 0, 10, -19, 4, 6, -8] || false
    }
}
