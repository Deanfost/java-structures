import hashTable.*;
import binarySearchTree.*;
import queue.*;
import tuple.*;

import java.util.ArrayList;

public class MainStructures {
  public static void main(String[] args) {
    queueTests();
  }

  private static void hashTableTests() {
    HashTable table = new HashTable();

    System.out.println("--- HASH TABLE TESTS ---");
    System.out.println();
    table.addValue("Dean", 124);
    table.addValue("Amy", 356);
    table.addValue("Jennifer", 98235);
    table.addValue("Emma", 46735);
    table.addValue("Braden", 35755);
    table.addValue("Braden", 3535);
    table.addValue("nedarB", 3593542);

    table.printTable();
    System.out.println();

    System.out.println("Braden: " + table.getValue("Braden"));
    System.out.println("nedarB: " + table.getValue("nedarB"));
    System.out.println("Dean: "+ table.getValue("Dean"));
    System.out.println("Emma: " + table.getValue("Emma"));
    System.out.println("Amy: " + table.getValue("Amy"));
    System.out.println("Joe: " + table.getValue("Joe"));

    System.out.println();
    System.out.println("Table length: " + table.count());

    System.out.println();
    System.out.println("Table cleared.");
    table.removeAll();
    table.printTable();
  }

  private static void BSTTests() {
    System.out.println("--- BST TESTS ---");
    BinarySearchTree bst = new BinarySearchTree();
    bst.addValuePair("Dean", 24);
    bst.addValuePair("God", 120);
    bst.addValuePair("Anna", 395);
    bst.addValuePair("Kendrick", 19052);
    bst.addValuePair("Post", 57524725);
    bst.addValuePair("Goa", 1294);

    System.out.println();
    bst.printTree();

    System.out.println();
    System.out.println("Size: " + bst.getSize());
    System.out.println("Post: " + bst.getValue("Post"));

    System.out.println();
    System.out.println("Array of tuples: ");
    Tuple[] arr = bst.toArray();
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  private static void queueTests() {
    Queue<String> q = new Queue<String>();
    q.enqueue("Hello");
    q.enqueue("Hi");
    q.enqueue("How are you?");
    q.enqueue("Great!");
    System.out.println("Queue size: " + q.getSize());
    System.out.println("--- Queue ---");
    q.printQueue();
    System.out.println();
    System.out.println("Head: " + q.front().toString());
    System.out.println("Tail: " + q.rear().toString());

    System.out.println();
    System.out.println("Dequeuing one item: " + q.dequeue());
    System.out.println("Queue size: " + q.getSize());
    System.out.println("--- Queue ---");
    q.printQueue();
    System.out.println();
    System.out.println("Head: " + q.front().toString());
    System.out.println("Tail: " + q.rear().toString());

    System.out.println();
    System.out.println("--- ArrayList of items ---");
    ArrayList<String> arrLst = q.toArrayList();
    System.out.println(arrLst);
  }
}
