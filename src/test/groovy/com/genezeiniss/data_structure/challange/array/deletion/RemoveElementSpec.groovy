package com.genezeiniss.data_structure.challange.array.deletion

import spock.lang.Specification
import spock.lang.Unroll

class RemoveElementSpec extends Specification {

    @Unroll
    def "remove element"() {
        when:
        def length = RemoveElement.removeElement_mySolution(input, val)

        then:
        assert length == expectedLength
        assert input.subList(0, expectedLength) == expectedArray

        where:
        input                    | val || expectedLength | expectedArray
        [3, 2, 2, 3]             | 3   || 2              | [2, 2]
        [0, 1, 2, 2, 3, 0, 4, 2] | 2   || 5              | [0, 1, 3, 0, 4]
        [2, 2, 2, 0, 0]          | 0   || 3              | [2, 2, 2]
        [1, 2, 3, 5, 4]          | 4   || 4              | [1, 2, 3, 5]
    }

    @Unroll
    def "remove element - first approach"() {
        when:
        def length = RemoveElement.removeElement_firstApproach(input, val)

        then: "the order of elements in array may vbe changed"
        assert length == expectedLength
        assert input.subList(0, expectedLength) == expectedArray

        where:
        input                    | val || expectedLength | expectedArray
        [3, 2, 2, 3]             | 3   || 2              | [2, 2]
        [0, 1, 2, 2, 3, 0, 4, 2] | 2   || 5              | [0, 1, 4, 0, 3]
        [2, 2, 2, 0, 0]          | 0   || 3              | [2, 2, 2]
        [1, 2, 3, 5, 4]          | 4   || 4              | [1, 2, 3, 5]
    }

    @Unroll
    def "remove element - second approach"() {
        when:
        def length = RemoveElement.removeElement_secondApproach(input, val)

        then:
        assert length == expectedLength
        assert input.subList(0, expectedLength) == expectedArray

        where:
        input                    | val || expectedLength | expectedArray
        [3, 2, 2, 3]             | 3   || 2              | [2, 2]
        [0, 1, 2, 2, 3, 0, 4, 2] | 2   || 5              | [0, 1, 3, 0, 4]
        [2, 2, 2, 0, 0]          | 0   || 3              | [2, 2, 2]
        [1, 2, 3, 5, 4]          | 4   || 4              | [1, 2, 3, 5]
    }
}
