package com.genezeiniss.data_structure;

import com.genezeiniss.data_structure.challange.linked_list.SplitLinkedListInParts;
import com.genezeiniss.data_structure.structure.ListNode;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DataStructureApplication {

    public static void main(String[] args) {

        //SpringApplication.run(DataStructureApplication.class, args);

        //ListNode root = constructLinkedList(List.of(1, 2, 3));
        ListNode root = constructLinkedList(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        //ListNode root = constructLinkedList(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        List<ListNode> splitList = SplitLinkedListInParts.splitListToParts(root, 1);
    }

    private static ListNode constructLinkedList(List<Integer> values) {

        ListNode head = null;

        for (int i = values.size() - 1; i >= 0; i--) {
            head = new ListNode(values.get(i), head);
        }

        return head;
    }
}