package com.genezeiniss.data_structure.sort_algorithm;

import com.genezeiniss.data_structure.split_algorithm.LinkedListSplit;
import com.genezeiniss.data_structure.structure.ListNode;
import com.genezeiniss.data_structure.utils.ListNodeUtil;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LinkedListRecursiveMergeSort {

    /**
     * Recursively divide linked list into sub-lists containing a single node.
     * Repeatedly merge the sub-lists to produce sorted sub-lists until one remains.
     * Returns a sorted linked link.
     */
    public static ListNode sortInAscendingOrderWithIterativeMerge(ListNode originalList) {

        // empty or single element list is already sorted. it called "naive sort".
        if (originalList == null || originalList.getNext() == null) {
            return originalList;
        }

        List<ListNode> splitLists = LinkedListSplit.splitAtMidPoint(originalList);
        ListNode leftHalfSorted = sortInAscendingOrderWithIterativeMerge(splitLists.get(0));
        ListNode rightHalfSorted = sortInAscendingOrderWithIterativeMerge(splitLists.get(1));
        return iterativeMerge(leftHalfSorted, rightHalfSorted);
    }

    public static ListNode sortInAscendingOrderWithRecursiveMerge(ListNode originalList) {

        // empty or single element list is already sorted. it called "naive sort".
        if (originalList == null || originalList.getNext() == null) {
            return originalList;
        }

        List<ListNode> splitLists = LinkedListSplit.splitAtMidPoint(originalList);
        ListNode leftHalfSorted = sortInAscendingOrderWithRecursiveMerge(splitLists.get(0));
        ListNode rightHalfSorted = sortInAscendingOrderWithRecursiveMerge(splitLists.get(1));
        return recursiveMerge(leftHalfSorted, rightHalfSorted);
    }

    /**
     * Merge two linked lists, sorting by data in nodes.
     * Returns a new merged list.
     * <p>
     * implementation:
     * 1. create a new linked list that contains node from merging left and right, with fake head, that is discarded later.
     * 2. set temporary list to the head of the merged list
     * 3. iterate over left and right until we reach the tail node of either (while left or right list's tail is not passed)
     * * 3.1 if left list is null (loop passed the left tail), add the node from right list to merged list
     * * 3.2 if right list is null (loop passed the right tail), add the node from left to merged list
     * * 3.3 otherwise --> obtain node values to perform comparison
     * * * 3.3.1 if value on left is less then right, set temporary list to left node; else set temporary list to the right node
     * * 3.4 move temporary list to the next node
     * 4. discard fake head by setting first merged node as head
     * 5. print and return merged list
     */
    public static ListNode iterativeMerge(ListNode leftList, ListNode rightList) {

        ListNode mergedList = new ListNode(0);
        ListNode temporaryList = mergedList;

        while (leftList != null || rightList != null) {

            if (leftList == null) {
                temporaryList.setNext(rightList);
                rightList = rightList.getNext();

            } else if (rightList == null) {
                temporaryList.setNext(leftList);
                leftList = leftList.getNext();

            } else {
                if (leftList.getValue() < rightList.getValue()) {
                    temporaryList.setNext(leftList);
                    leftList = leftList.getNext();

                } else {
                    temporaryList.setNext(rightList);
                    rightList = rightList.getNext();
                }
            }
            temporaryList = temporaryList.getNext();
        }
        mergedList = mergedList.getNext();

        ListNodeUtil.printList("merged list node is: ", mergedList);
        return mergedList;
    }

    public static ListNode recursiveMerge(ListNode leftList, ListNode rightList) {

        ListNode mergedList;

        if (leftList == null) {
            return rightList;
        }
        if (rightList == null) {
            return leftList;
        }

        if (leftList.getValue() < rightList.getValue()) {
            mergedList = leftList;
            mergedList.setNext(recursiveMerge(leftList.getNext(), rightList));
        } else {
            mergedList = rightList;
            mergedList.setNext(recursiveMerge(leftList, rightList.getNext()));
        }
        ListNodeUtil.printList("merged list node is: ", mergedList);
        return mergedList;
    }
}
