package com.genezeiniss.data_structure.challange.array

import spock.lang.Specification
import spock.lang.Unroll

class ThirdMaximumNumberSpec extends Specification {

    @Unroll
    def "third max number"() {
        when:
        def maxValue = ThirdMaximumNumber.thirdMax(input)

        then:
        assert maxValue == expecedMaxValue

        where:
        input        || expecedMaxValue
        [3, 2, 1]    || 1
        [1, 2]       || 2
        [2, 2, 3, 1] || 1
        [1, 1, 2]    || 2
    }
}
