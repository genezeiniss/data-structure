package com.genezeiniss.data_structure.algorithm.search

import spock.lang.Specification
import spock.lang.Unroll

class LinearSearchSpec extends Specification {

    @Unroll
    def "search dor number - #scenario"() {
        when:
        def targetIndex = LinearSearch.searchForNumber(list, target)

        then:
        assert targetIndex == expectedIndex

        where:
        scenario                                            | list                            | target || expectedIndex
        "list is sorted ascending; target is first element" | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 1      || 0
        "list is sorted ascending; target is last element"  | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 10     || 9
        "list is sorted ascending; target is the middle"    | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 5      || 4
        "list is sorted ascending; target is not included"  | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 11     || -1
        "list is not sorted; target included"               | [1, 2, 7, 4, 5, 6, 3, 8, 9, 10] | 3      || 6
        "list is empty; "                                   | []                              | 1      || -1
    }
}
