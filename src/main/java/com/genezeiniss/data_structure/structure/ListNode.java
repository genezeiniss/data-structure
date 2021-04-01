package com.genezeiniss.data_structure.structure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListNode {

    private int value;
    private ListNode next;

    public ListNode(int value) {
        this.value = value;
    }
}
