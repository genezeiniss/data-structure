package com.genezeiniss.data_structure;

import com.genezeiniss.data_structure.structure.ListNode;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataStructureApplication {

    public static void main(String[] args) {

        //SpringApplication.run(DataStructureApplication.class, args)


        ListNode head = new ListNode(1);
        head.setNext(new ListNode(2));
        head.getNext().setNext(new ListNode(3));
        head.getNext().getNext().setNext(new ListNode(4));
        head.getNext().getNext().getNext().setNext(new ListNode(5));
        head.getNext().getNext().getNext().getNext().setNext(new ListNode(6));
    }
}