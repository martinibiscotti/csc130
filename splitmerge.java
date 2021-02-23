// Martin Biscocho
// 2021-02-22
// CSC 130 Section 1 - Split Merge

import java.io.*;
import java.util.*;

class Node {
    String data;
    Node next;

    Node (String d) {
        data = d;
        next = null;
    }
}

class LinkedList {
    Node head;

    public void add(String d) {
        Node newNode = new Node(d);
        if (head == null) {
            head = newNode;
        }
        else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    public void readFile(String file) throws FileNotFoundException {
        File f = new File(file);
        Scanner s = new Scanner(f);
        while (s.hasNextLine()) {
            this.add(s.nextLine());
        }
    }

    public void traverse() {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public LinkedList split() {
        Node curr = head;
        int count = 0;
        while (curr != null) {
            curr = curr.next;
            count += 1;
        }
        curr = head;
        for (int i= 0; i < (count-1)/2; ++i) {
            curr = curr.next;
        }
        LinkedList list = new LinkedList();
        list.head = curr.next;
        curr.next = null;
        return list;
    }

    public void merge(LinkedList list2) {
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = list2.head;
    }
}

class Driver {
    public static void driver() throws FileNotFoundException {
        LinkedList list1 = new LinkedList();

        list1.readFile("input.txt");
        System.out.println("pre-split (list1)\n-----------------");
        list1.traverse();

        LinkedList list2 = list1.split();
        System.out.println("\npost-split (list1)\n------------------");
        list1.traverse();
        System.out.println("\npost-split (list2)\n------------------");
        list2.traverse();

        list1.merge(list2);
        System.out.println("\npost-merge (list1)\n------------------");
        list1.traverse();
    }
}

class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Driver.driver();
    }
}
