package com.genezeiniss.data_structure.challange

import spock.lang.Specification
import spock.lang.Unroll

import static com.genezeiniss.data_structure.fixture.ListNodeFixture.constructLinkedList

class SplitLinkedListInPartsSpec extends Specification {

    @Unroll
    def "split to parts"() {
        given: "nodes values"
        def root = constructLinkedList(values)

        when: "split to parts"
        def splitList = SplitLinkedListInParts.splitListToParts(root, parts)

        then: "array values es expected"
        def splitListValues = []
        splitList.forEach { listNode ->
            def nodeValues = new ArrayList()
            if (listNode != null) {
                def node = listNode
                while (node != null) {
                    nodeValues.add(node.value)
                    node = node.next
                }
            }
            splitListValues.add(nodeValues)
        }
        assert splitListValues == expectedSplitListValues


        where:
        values                              | parts || expectedSplitListValues
        [1, 2, 3]                           | 5     || [[1], [2], [3], [], []]
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]     | 3     || [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11] | 3     || [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11]]
        [1, 2, 3]                           | 1     || [[1, 2, 3]]
        []                                  | 5     || [[], [], [], [], []]
    }
}
