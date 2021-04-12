package com.genezeiniss.data_structure.challange.array.in_place_operations

import spock.lang.Specification
import spock.lang.Unroll

class MoveZeroesSpec extends Specification {

    @Unroll
    def "move zeros"() {
        when:
        MoveZeroes.moveZeroes(input)

        then:
        assert input == expectedArray

        where:
        input              || expectedArray
        [0, 1, 2, 0, 3]    || [1, 2, 3, 0, 0]
        [1, 2, 0, 3, 0, 0] || [1, 2, 3, 0, 0, 0]
        [0]                || [0]
    }
}
