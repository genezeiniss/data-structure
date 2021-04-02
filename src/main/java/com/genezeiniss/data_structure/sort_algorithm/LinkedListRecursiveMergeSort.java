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
        return iterativeMergeWithAscendingSort(leftHalfSorted, rightHalfSorted);
    }

    public static ListNode sortInAscendingOrderWithRecursiveMerge(ListNode originalList) {

        // empty or single element list is already sorted. it called "naive sort".
        if (originalList == null || originalList.getNext() == null) {
            return originalList;
        }

        List<ListNode> splitLists = LinkedListSplit.splitAtMidPoint(originalList);
        ListNode leftHalfSorted = sortInAscendingOrderWithRecursiveMerge(splitLists.get(0));
        ListNode rightHalfSorted = sortInAscendingOrderWithRecursiveMerge(splitLists.get(1));
        return recursiveMergeWithAscendingSort(leftHalfSorted, rightHalfSorted);
    }

    /**
     * Merge two linked lists, sorting by data in nodes.
     * Returns a new merged list.
     */
    public static ListNode iterativeMergeWithAscendingSort(ListNode leftList, ListNode rightList) {

        // create a new linked list that contains node from merging left and right,
        // with fake head, that is discarded later.
        ListNode mergedList = new ListNode(0);

        // set temporary list to the head of the merged list
        ListNode temporaryList = mergedList;

        // iterate over left and right until we reach the tail node of either
        while (leftList != null || rightList != null) {

            // if left list is null, we're passed the tail
            // add the node from right list to merged list
            if (leftList == null) {
                temporaryList.setNext(rightList);
                rightList = rightList.getNext();

                // if left list is null, we're passed the tail
                // add the tail node from left to merged list
            } else if (rightList == null) {
                temporaryList.setNext(leftList);
                leftList = leftList.getNext();

                // not at either tail node
                // obtain node values to perform comparison
            } else {

                // if value on left is less then right, set temporary list to left node
                if (leftList.getValue() < rightList.getValue()) {
                    temporaryList.setNext(leftList);
                    leftList = leftList.getNext();

                    // set temporary list to left node
                } else {
                    temporaryList.setNext(rightList);
                    rightList = rightList.getNext();
                }
            }

            // move temporary list to next node
            temporaryList = temporaryList.getNext();
        }


        // discard fake head by setting first merged node as head
        mergedList = mergedList.getNext();

        ListNodeUtil.printList("merged list node is: ", mergedList);
        return mergedList;
    }

    public static ListNode recursiveMergeWithAscendingSort(ListNode leftList, ListNode rightList) {

        ListNode mergedList;

        if (leftList == null) {
            return rightList;
        }
        if (rightList == null) {
            return leftList;
        }

        if (leftList.getValue() < rightList.getValue()) {
            mergedList = leftList;
            mergedList.setNext(recursiveMergeWithAscendingSort(leftList.getNext(), rightList));
        } else {
            mergedList = rightList;
            mergedList.setNext(recursiveMergeWithAscendingSort(leftList, rightList.getNext()));
        }
        ListNodeUtil.printList("merged list node is: ", mergedList);
        return mergedList;
    }
}
