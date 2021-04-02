package com.genezeiniss.data_structure.algorithm.sort

import spock.lang.Specification
import spock.lang.Unroll

class RecursiveMergeSortSpec extends Specification {

    @Unroll
    def "sort numbers in ascending order - #scenario"() {
        when: "sort in ascending order method is called"
        def sortedList = RecursiveMergeSort.sortNumbers(unsortedList)

        then: "sorted list size expected to be equal to unsorted list"
        if (sortedList != null)
            assert sortedList.size() == unsortedList.size()

        and: "list expected to be sorted as expected"
        assert sortedList == expectedSortedList

        where:
        scenario                | unsortedList           || expectedSortedList
        "list is null"          | null                   || null
        "list is empty"         | []                     || []
        "list has one value"    | [1]                    || [1]
        "unsorted list"         | [8, 5, 2, 1, 4, 3, 10] || [1, 2, 3, 4, 5, 8, 10]
        "list hase same values" | [5, 3, 6, 6, 8, 1, 4]  || [1, 3, 4, 5, 6, 6, 8]
    }
}
