package com.genezeiniss.data_structure.fixture

import com.genezeiniss.data_structure.structure.ListNode

class ListNodeFixture {

    static ListNode constructLinkedList(List values) {

        ListNode head = null

        for (int i = values.size() - 1; i >= 0; i--) {
            head = new ListNode(values[i] as int, head)
        }

        return head
    }
}
