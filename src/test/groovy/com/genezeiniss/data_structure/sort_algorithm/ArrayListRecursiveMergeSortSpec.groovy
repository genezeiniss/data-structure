package com.genezeiniss.data_structure.sort_algorithm

import spock.lang.Specification

class ArrayListRecursiveMergeSortSpec extends Specification {

    def "sort array list in ascending order"() {
        given: "unsorted list"
        def unsortedList = [5, 2, 1, 4, 3]

        when: "sort in ascending order method is called"
        def sortedList = ArrayListRecursiveMergeSort.sortInAscendingOrder(unsortedList)

        then: "sorted list size expected to be equal to unsorted list"
        assert sortedList.size() == unsortedList.size()

        and: "list expected to be sorted in ascending order"
        assert sortedList == unsortedList.sort()
    }
}
