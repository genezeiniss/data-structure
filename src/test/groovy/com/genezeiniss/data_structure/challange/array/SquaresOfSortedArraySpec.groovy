package com.genezeiniss.data_structure.challange.array

import spock.lang.Specification

class SquaresOfSortedArraySpec extends Specification {

    def "sorted squares"() {
        given: "unsorted list"
        def unsortedList = [-4, -1, 0, 3, 10]

        when: "sorted squares"
        def sortedSquares = SquaresOfSortedArray.sortedSquares(unsortedList)

        then: "list expected to be sorted in ascending order"
        assert sortedSquares == [0, 1, 9, 16, 100]
    }
}
