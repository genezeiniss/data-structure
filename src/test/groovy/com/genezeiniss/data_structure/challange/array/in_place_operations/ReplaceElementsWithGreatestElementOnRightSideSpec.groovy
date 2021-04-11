package com.genezeiniss.data_structure.challange.array.in_place_operations

import spock.lang.Specification
import spock.lang.Unroll

class ReplaceElementsWithGreatestElementOnRightSideSpec extends Specification {

    @Unroll
    def "replace elements"() {
        when:
        ReplaceElementsWithGreatestElementOnRightSide.replaceElements(input)

        then:
        assert input == expectedArray

        where:
        input                || expectedArray
        [17, 18, 5, 4, 6, 1] || [18, 6, 6, 6, 1, -1]
        [400]                || [-1]
    }
}
