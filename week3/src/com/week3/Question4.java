package com.week3;

public class Question4 {
    // construct Node class
    static Node head;
    static class Node{
        int value;
        Node next;
        public Node(int value ){
            this.value = value;
            next = null;
        }
    }

    static int detectAndRemoveLoop(Node node){
        Node toitorse = node;
        Node hare = node;
        while(toitorse != null && hare != null && hare.next != null){
            toitorse = toitorse.next;
            hare = hare.next.next;
            if (toitorse == hare){
                removeLoopLinkedList(toitorse, node);
                return 1;
            }
        }
        return 0;
    }

    static void removeLoopLinkedList(Node meetingNode, Node head){
        Node pointer1 = meetingNode;
        Node pointer2 = meetingNode;
        int k = 1; // count the number of nodes in loop

        while (pointer1.next != pointer2){
            pointer1 = pointer1.next;
            k++;
        }

        pointer1 = head;
        pointer2 = head;
        for (int i = 0; i < k ; i++){
            pointer2 = pointer2.next;
        }
        while(pointer1 != pointer2){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        while (pointer1.next != pointer2){
            pointer1 = pointer1.next;
        }
        pointer1.next = null;
    }

    void printLinkedList(Node node){
        while (node != null){
            System.out.println(node.value);
            node = node.next;
        }
    }

    public static void main(String[] arg){

        Question4 q4 = new Question4();
        q4.head = new Node(5);
        q4.head.next = new Node(6);
        q4.head.next.next= new Node(8);
        q4.head.next.next.next = new Node(1);
        q4.head.next.next.next.next = new Node(3);
        q4.head.next.next.next.next.next = new Node(10);
        q4.head.next.next.next.next.next.next = new Node(9);

        // create a loop
        q4.head.next.next.next.next.next.next.next = q4.head.next.next.next;
        q4.detectAndRemoveLoop(head);
        System.out.println("Linked List after removing loop");
        q4.printLinkedList(head);

    }


}

