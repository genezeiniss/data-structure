package com.genezeiniss.data_structure.utils;

import com.genezeiniss.data_structure.structure.ListNode;

public class ListNodeUtil {

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
