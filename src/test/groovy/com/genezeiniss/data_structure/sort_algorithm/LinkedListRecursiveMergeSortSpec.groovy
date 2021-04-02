package com.genezeiniss.data_structure.sort_algorithm

import spock.lang.Specification
import spock.lang.Unroll

import static com.genezeiniss.data_structure.fixture.ListNodeFixture.constructLinkedList

class LinkedListRecursiveMergeSortSpec extends Specification {

    @Unroll
    def "sort in ascending order with iterative merge -#scenario"() {
        given: "nodes values"
        def listNode = constructLinkedList(values)

        when: "sort in ascending order with iterative merge is called"
        def sortedList = LinkedListRecursiveMergeSort.sortInAscendingOrderWithIterativeMerge(listNode)

        then: "list sorted as expected"
        assert sortedList == expectedList

        where:
        scenario                        | values                || expectedList
        "list has even number of nodes" | [7, 6, 5, 4, 3, 2, 1] || constructLinkedList([1, 2, 3, 4, 5, 6, 7])
        "list has odd number of nodes"  | [5, 3, 1, 6, 4, 2]    || constructLinkedList([1, 2, 3, 4, 5, 6])
        "list has same values"          | [2, 3, 1, 6, 1, 2]    || constructLinkedList([1, 1, 2, 2, 3, 6])
        "list is empty"                 | []                    || constructLinkedList([])
        "list has one element"          | [1]                   || constructLinkedList([1])
    }

    @Unroll
    def "sort in ascending order with recursive merge -#scenario"() {
        given: "nodes values"
        def listNode = constructLinkedList(values)

        when: "sort in ascending order with re cursive merge is called"
        def sortedList = LinkedListRecursiveMergeSort.sortInAscendingOrderWithRecursiveMerge(listNode)

        then: "list sorted as expected"
        assert sortedList == expectedList

        where:
        scenario                        | values                || expectedList
        "list has even number of nodes" | [7, 6, 5, 4, 3, 2, 1] || constructLinkedList([1, 2, 3, 4, 5, 6, 7])
        "list has odd number of nodes"  | [5, 3, 1, 6, 4, 2]    || constructLinkedList([1, 2, 3, 4, 5, 6])
        "list has same values"          | [2, 3, 1, 6, 1, 2]    || constructLinkedList([1, 1, 2, 2, 3, 6])
        "list is empty"                 | []                    || constructLinkedList([])
        "list has one element"          | [1]                   || constructLinkedList([1])
    }
}
