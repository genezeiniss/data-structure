package com.genezeiniss.data_structure.utils;

import com.genezeiniss.data_structure.structure.ListNode;

import java.util.List;

public class ListNodeUtil {

    public static ListNode constructLinkedList(List<Integer> values) {

        ListNode head = null;

        for (int i = values.size() - 1; i >= 0; i--) {
            head = new ListNode(values.get(i), head);
        }

        return head;
    }

    public static void printList(String msg, ListNode head) {

        System.out.print(msg);

        ListNode node = head;
        while (node != null) {
            System.out.print(node.getValue() + " —> ");
            node = node.getNext();
        }

        System.out.println("null");
    }

    public static int getSize(ListNode head) {
        int size = 0;
        ListNode node = head;
        while (node != null) {
            size++;
            node = node.getNext();
        }
        return size;
    }
}
