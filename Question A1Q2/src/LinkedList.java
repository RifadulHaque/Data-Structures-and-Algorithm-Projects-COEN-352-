/*
Write a method delete() that takes an int argument k and deletes the kth element in a
linked list, if it exists.


 */

//import java.io.*;
//import java.util.LinkedList;


class LinkedList {
    Node head; // head of list

    public static class Node {
        int number;
        Node next;

        Node(int num) {
            number = num;
            next = null;
        } // parametrized Constructor
    }

    public void push(int num){
        Node newFirst= new Node(num);
        newFirst.next=head;
        head=newFirst;
    }
    //delete method
    public void delete(int k) {
        Node first = head;
        Node oldFirst = null;

        int tracker = 0;

        if (k == 1) {
            head = head.next;
        } else {

            for (int i = 1; i <= k; i++) {

                tracker++;
                if (k == tracker) {
                    oldFirst.next = first.next;
                }
                else if (tracker != 0) {
                    oldFirst= first;
                }

                first = oldFirst.next;
            }

        }


    }

    //method for printing the edited list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.number + " ");
            temp = temp.next;
        }
    }


    public static void main(String[] args) {
        //inserting elements in the list
        LinkedList List = new LinkedList();


        List.push(4);
        List.push(50);
        List.push(12);
        List.push(15);
        List.push(18);
        List.push(25);
        List.push(40);
        List.push(45);

        /*

        List.head = new Node(11);
        List.head.next = new Node(21);
        List.head.next.next = new Node(31);
        List.head.next.next.next = new Node(41);
        List.head.next.next.next.next = new Node(51);
        List.head.next.next.next.next.next = new Node(61);
        List.head.next.next.next.next.next.next = new Node(71);
        List.head.next.next.next.next.next.next.next = new Node(81);
        List.head.next.next.next.next.next.next.next.next = new Node(91);
        List.head.next.next.next.next.next.next.next.next.next = new Node(111);
        List.head.next.next.next.next.next.next.next.next.next.next= new Node(121);
        List.head.next.next.next.next.next.next.next.next.next.next.next = new Node(131);

        */
        System.out.print("Before Deleting :");
        List.printList();

        //deleting the kth element
        List.delete(5);
        //L.delete(1);


        //printing the edited list
        System.out.print("\nAfter Deleting :");
        List.printList();




    }
}