package com.genezeiniss.data_structure.algorithm.sort

import spock.lang.Specification

class LinearSortSpec extends Specification {

    def "sort numbers"() {
        given: "unsorted list"
        def unsortedList = [5, 2, 1, 4, 3]

        when: "sort numbers method is called"
        def sortedList = LinearSort.sortNumbers(unsortedList)

        then: "sorted list size expected to be equal to unsorted list"
        assert sortedList.size() == unsortedList.size()

        and: "list expected to be sorted in ascending order"
        assert sortedList == unsortedList.sort()
    }
}
