package com.genezeiniss.data_structure.algorithm.split;

import com.genezeiniss.data_structure.structure.ListNode;
import com.genezeiniss.data_structure.utils.ListNodeUtil;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class LinkedListSplit {

    /**
     * Divide the list node (linked list) into two sub-lists, containing alternating elements.
     * If we number the elements 0, 1, 2, … then all the even elements should go in the first list, and all the odd elements in the second.
     * Return list of two nodes.
     * <p>
     * note:
     * the elements in the list will be in reverse order
     */
    public static List<ListNode> alternatingSplit(ListNode originalList) {

        ListNode firstList = null;
        ListNode secondList = null;

        while (originalList != null) {

            ListNode temporaryList = originalList;
            originalList = originalList.getNext();

            temporaryList.setNext(firstList);
            firstList = temporaryList;

            if (originalList != null) {

                temporaryList = originalList;
                originalList = originalList.getNext();

                temporaryList.setNext(secondList);
                secondList = temporaryList;
            }
        }

        ListNodeUtil.printList("first list: ", firstList);
        ListNodeUtil.printList("second list: ", secondList);

        return Arrays.asList(firstList, secondList);
    }

    /**
     * Divide the list node (linked list) at midpoint into sub-lists.
     * Return array of left and right sub-lists.
     * Note: If the length is odd, the extra node will go in the left list.
     */
    public static List<ListNode> splitAtMidPoint(ListNode originalList) {
        ListNode leftHalf;
        ListNode rightHalf;

        int size = ListNodeUtil.getSize(originalList);
        if (size < 2) {
            leftHalf = originalList;
            return Collections.singletonList(leftHalf);
        }

        // find mid node
        int midPoint = (size - 1) / 2;
        ListNode midNode = originalList;

        for (int i = 0; i < midPoint; i++) {
            midNode = midNode.getNext();
        }

        // left half - make mid node a tail node by cutting the reference to the next nodes
        // right half - initiate the list, where head node is next to the mid node
        leftHalf = originalList;
        rightHalf = midNode.getNext();
        midNode.setNext(null);

        ListNodeUtil.printList("left sub-list: ", leftHalf);
        ListNodeUtil.printList("right sub-list: ", rightHalf);

        return Arrays.asList(leftHalf, rightHalf);
    }
}
