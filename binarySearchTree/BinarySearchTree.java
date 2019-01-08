package binarySearchTree;

import tuple.*;

/* Definition of a Binary Search Tree of a String key and int value.
 * All keys are unique, but values may not be.
 */

 public class BinarySearchTree {
   private BinarySearchInner tree;
   private int itemCount;

   /* Definition of actual inner tree. */
   private class BinarySearchInner {
     String key;
     int value;
     BinarySearchInner left;
     BinarySearchInner right;

     public BinarySearchInner(String key, int value) {
       this.key = key;
       this.value = value;
       left = null;
       right = null;
     }
   }

   public BinarySearchTree() {
     itemCount = 0;
   }

   /* Returns the element count of the tree. */
   public int getSize() {
     return this.itemCount;
   }

   /* Adds new tuple from the given values in the tree. */
   public void addValuePair(String key, int value) {
     this.tree = addValueHelper(key, value, this.tree);
   }

   private BinarySearchInner addValueHelper(String key, int value,
    BinarySearchInner node) {
     if (node == null) {
       // Insert the new element as the head
       itemCount++;
       return new BinarySearchInner(key, value);
     }
     else {
       // Check if this key is unique
       if (!node.key.equals(key)) {
         if (key.compareTo(node.key) > 0) {
           // Add the node to the right of the tree
           node.right = addValueHelper(key, value, node.right);
         }
         else {
           // Add the node to the left of the tree
           node.left = addValueHelper(key, value, node.left);
         }
       }
       return node;
     }
   }

   /* Returns the value assocated with the key if availible. */
   public Integer getValue(String key) {
     return getValueHelper(key, this.tree);
   }

   private Integer getValueHelper(String key, BinarySearchInner node) {
     Integer toReturn = null;
     if (node != null) {
       if (key.equals(node.key)) {
         toReturn = node.value;
       }
       else if(key.compareTo(node.key) > 0) {
         // Search the right subtree
         toReturn = getValueHelper(key, node.right);
       }
       else {
         // Search the left subtree
         toReturn = getValueHelper(key, node.left);
       }
     }
     return toReturn;
   }

   /* Returns all values in the tree in an array of Tuples in ascending
    order by tag. */
   public Tuple[] toArray() {
     Tuple[] array = new Tuple[this.itemCount];
     toArrayHelper(this.tree, array, 0);
     return array;
   }

   public int toArrayHelper(BinarySearchInner node, Tuple[] arr,
     int index) {
     if (node != null) {
       // Add the left subtree
       if (node.left != null) {
         index = toArrayHelper(node.left, arr, index);
       }
       // Add the current node
       arr[index] = new Tuple(node.key, node.value);
       index++;
       // Add the right subtree
       if (node.right != null) {
         index = toArrayHelper(node.right, arr, index);
       }
     }
     return index;
   }

   /* Prits out all of the elments of the tree using inorder traversal. */
   public void printTree() {
     printTreeHelper(this.tree);
   }

   private void printTreeHelper(BinarySearchInner node) {
     if (node != null) {
       printTreeHelper(node.left);
       System.out.println(node.key + ": " + node.value);
       printTreeHelper(node.right);
     }
   }
 }
