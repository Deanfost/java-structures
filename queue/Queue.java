package queue;

import java.util.ArrayList;
/* Contains defintion for a Queue (FIFO) class. Implemented using a Singly
 * Linked List with a head and tail node, contained with a dummy container.
 * Class contains generics.
 */

 public class Queue<T> {
   private QueueInner<T> head;
   public QueueInner<T> tail;
   private int itemCount;

   private class QueueInner<T> {
     T value;
     QueueInner<T> next;

     public QueueInner(T value) {
       this.value = value;
       this.next = null;
     }
   }

   public Queue() {
     this.head = null;
     this.tail = null;
     this.itemCount = 0;
   }

   public int getSize() {
     return this.itemCount;
   }

   /* Adds an item to the back of the Queue. */
   public void enqueue(T item) {
     if (this.head == null) {
       // Add the first item to the front of the queue
       QueueInner newItem = new QueueInner(item);
       this.head = newItem;
       this.tail = newItem.next;
       this.itemCount++;
     }
     else if(this.tail == null){
       // Add another item to the back of the first item
       QueueInner newItem = new QueueInner(item);
       this.head.next = newItem;
       this.tail = newItem;
       this.itemCount++;
     }
     else {
       // Add another item onto the back of the tail
       QueueInner newItem = new QueueInner(item);
       this.tail.next = newItem;
       this.tail = newItem;
       this.itemCount++;
     }
   }

   /* Pops an item from the front of the queue. */
   public T dequeue() {
     if (this.head != null) {
       T headItem = this.head.value;
       this.head = this.head.next;
       this.itemCount--;
       return headItem;
     }
     else {
       return null;
     }
   }

   /* Returns a shallow copy of the front-most item. */
   public T front() {
     return this.head.value;
   }

   /* Returns a shallow copy of the rear-most item. */
   public T rear() {
     return this.tail.value;
   }

   /* Returns a new ArrayList containing all elements of the Queue. */
   public ArrayList<T> toArrayList() {
     ArrayList<T> arrayList = new ArrayList<T>();
     QueueInner<T> curr = this.head;
     while (curr != null) {
       arrayList.add(curr.value);
       curr = curr.next;
     }
     return arrayList;
   }

   /* Prints out the Queue. */
   public void printQueue() {
     QueueInner<T> curr = this.head;
     while (curr != null) {
       System.out.println(curr.value);
       curr = curr.next;
     }
   }
 }
