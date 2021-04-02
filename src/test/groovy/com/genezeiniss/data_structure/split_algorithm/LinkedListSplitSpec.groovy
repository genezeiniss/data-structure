package com.genezeiniss.data_structure.split_algorithm


import spock.lang.Specification
import spock.lang.Unroll

import static com.genezeiniss.data_structure.fixture.ListNodeFixture.constructLinkedList

class LinkedListSplitSpec extends Specification {

    @Unroll
    def "alternating split - #scenario"() {
        given: "nodes values"
        def listNode = constructLinkedList(values)

        when: "alternating split method is called"
        def splitList = LinkedListSplit.alternatingSplit(listNode)

        then: "array of two linked lists expected to be returned"
        def firstList = splitList[0]
        def secondList = splitList[1]

        and: "each list expected to contain alternating nodes from poriginal list"
        assert firstList == expectedFirstList
        assert secondList == expectedSecondList

        where:
        scenario                        | values                || expectedFirstList                 | expectedSecondList
        "list has even number of nodes" | [1, 2, 3, 4, 5, 6, 7] || constructLinkedList([7, 5, 3, 1]) | constructLinkedList([6, 4, 2])
        "list has odd number of nodes"  | [1, 2, 3, 4, 5, 6]    || constructLinkedList([5, 3, 1])    | constructLinkedList([6, 4, 2])
        "list is empty"                 | []                    || constructLinkedList([])           | constructLinkedList([])
        "list has one element"          | [1]                   || constructLinkedList([1])          | null
    }

    @Unroll
    def "split at mid point - #scenario"() {
        given: "nodes values"
        def listNode = constructLinkedList(values)

        when: "split at mid point method is called"
        def splitList = LinkedListSplit.splitAtMidPoint(listNode)

        then: "array of two linked lists expected to be returned"
        def firstList = splitList[0]
        def secondList = splitList[1]

        and: "each sublist expected to contain nodes in the same order, as in original list"
        assert firstList == expectedFirstList
        assert secondList == expectedSecondList

        where:
        scenario                        | values                || expectedFirstList                 | expectedSecondList
        "list has even number of nodes" | [1, 2, 3, 4, 5, 6, 7] || constructLinkedList([1, 2, 3, 4]) | constructLinkedList([5, 6, 7])
        "list has odd number of nodes"  | [1, 2, 3, 4, 5, 6]    || constructLinkedList([1, 2, 3])    | constructLinkedList([4, 5, 6])
        "list is empty"                 | []                    || constructLinkedList([])           | constructLinkedList([])
        "list has one element"          | [1]                   || constructLinkedList([1])          | null
    }
}
