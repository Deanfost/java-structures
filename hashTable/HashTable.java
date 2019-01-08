package hashTable;

import java.util.LinkedList;
import java.lang.Math.*;
import tuple.*;

/* Definition for a Hash Table. Uses arrays of LinkedLists that contain
 * tuples of key value pairs as buckets.
 */

 public class HashTable {
   private final int TABLE_LENGTH = 57;
   private LinkedList<Tuple>[] table;

   public HashTable() {
     this.table = new LinkedList[TABLE_LENGTH];
   }

   /* Adds the value to the table based off of a calulated hash index. */
   public void addValue(String key, int value) {
     int newIndex = calculateHash(key) % TABLE_LENGTH;
     if (this.table[newIndex] == null) {
       // Empty bucket
       this.table[newIndex] = new LinkedList<Tuple>();
       this.table[newIndex].add(new Tuple(key, value));
     } else {
       // Non-empty bucket
       this.table[newIndex].add(new Tuple(key, value));
     }
   }

   /* Calculates the hash of the key. */
   private int calculateHash(String key) {
     int hash = 7;
     hash = key.hashCode() * hash;
     hash = hash * key.length();
     return Math.abs(hash);
   }

   /* Returns the value associated with the key if available. */
   public Integer getValue(String key) {
     int index = calculateHash(key) % TABLE_LENGTH;
     LinkedList<Tuple> list = this.table[index];
     if (list != null) {
       // Search the bucket for the key
       Tuple[] arr = list.toArray(new Tuple[0]);
       for (int i = 0; i < arr.length; i++) {
         if (arr[i].getKey().equals(key)) {
           return arr[i].getValue();
         }
       }
      }
      return null;
     }

    /* Returns the element count in all buckets. */
    public int count() {
      int count = 0;
      for (int i = 0; i < this.table.length; i++) {
        if (this.table[i] != null)
          count += this.table[i].size();
      }
      return count;
    }

    /* Clears the table. */
    public void removeAll() {
      for (int i = 0; i < this.table.length; i++) {
        this.table[i] = null;
      }
    }

   /* Prints out all of the table's buckets. */
   public void printTable() {
     for (int i = 0; i < TABLE_LENGTH; i++) {
       if (this.table[i] != null){
         Tuple[] arr = this.table[i].toArray(new Tuple[0]);
         for (int k = 0; k < arr.length; k++) {
           System.out.print(arr[k]);
           System.out.print(" - ");
         }
         System.out.println();
       }
       else {
         System.out.println("[]");
       }
     }
   }
 }
