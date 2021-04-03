package com.genezeiniss.data_structure.challange;

import com.genezeiniss.data_structure.structure.ListNode;
import com.genezeiniss.data_structure.utils.ListNodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".
 * The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.
 * The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.
 * Return a List of ListNode's representing the linked list parts that are formed.
 * Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
 * <p>
 * Notes:
 * The length of root will be in the range [0, 1000].
 * Each value of a node in the input will be an integer in the range [0, 999].
 * k will be an integer in the range [1, 50].
 */
public class SplitLinkedListInParts {

    /**
     * implementation:
     * 1. find size of the linked node
     * 2. divide the length to k, to understand number elements in each part
     * 3. find modulo
     * 4. create array in length k
     * 5. split list node to sub-lists and add them to array, using 'for loop'
     * * for each run of loop:
     * * 5.1 create temporary list node
     * * 5.2 add temporary list node to the array at place [i]
     * * 5.3 find tail node of current part (pay attention, that if modulo > 0, part should receive additional element)
     * * 5.4 set root head to the next node of tail node
     * * 5.6 remove reference to the next node from current tail node
     */
    public static List<ListNode> splitListToParts(ListNode root, int k) {

        List<ListNode> splitList = new ArrayList<>(k);

        int size = ListNodeUtil.getSize(root);
        int elements = size / k;
        int modulo = size % k;

        for (int i = 0; i < k; i++) {

            ListNode temporary = root;
            splitList.add(i, temporary);

            ListNode tailNode = temporary;

            int elementsInPart = elements;
            if (modulo > 0) {
                elementsInPart = elements + 1;
                modulo -= 1;
            }

            for (int count = 1; count < elementsInPart; count++) {
                tailNode = tailNode.getNext();
            }

            if (root != null) {
                root = tailNode.getNext();
            }

            if (tailNode != null) {
                tailNode.setNext(null);
            }
        }

        printValues(splitList);
        return splitList;
    }

    public static void printValues(List<ListNode> nodes) {

        nodes.forEach(node -> {
            List<Integer> values = new ArrayList<>();
            if (node != null) {
                while (node != null) {
                    values.add(node.getValue());
                    node = node.getNext();
                }
            }
            System.out.print(values);
        });
    }
}
