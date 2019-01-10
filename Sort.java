import java.util.Random;
import java.util.Arrays;
import java.lang.Math.*;

/* Contains a definition for common sorting algorithms (ascending order).
 */

public class Sort {
  static final int ARR_SIZE = 100000000;

  public static void main(String[] args) {
    int[] arr = new int[ARR_SIZE];
    Random rand = new Random();

    // System.out.println("--- Unsorted array ---");
    for (int i = 0; i< ARR_SIZE; i++) {
      // Pick a number between 0 and 50 every time to add to array
      arr[i] = rand.nextInt(ARR_SIZE + 1);
      // System.out.println(arr[i]);
    }

    // System.out.println("--- Sorted array ---");

    long millis = System.currentTimeMillis();
    arr = mergeSort(arr);
    // bubbleSort(arr);
    long elapsed = System.currentTimeMillis();
    System.out.println("Execution time: " + ((elapsed - millis) / 1000) + " seconds");
    // for (int i = 0; i< ARR_SIZE; i++) { System.out.println(arr[i]); }
  }

  /* Sort each pair of numbers linearly until list is sorted. */
  public static void bubbleSort(int[] list) {
    boolean shouldSort;
    // Iterate as many times as we need to
    do {
      shouldSort = false;
      for (int i = 0; i < ARR_SIZE - 1; i++) {
        if (list[i] > list[i + 1]) {
          int temp = list[i];
          list[i] = list[i + 1];
          list[i + 1] = temp;
          shouldSort = true;
        }
      }
    } while (shouldSort);
  }

  /* Split the list into pairs of numbers, then sort them. Combine pairs with
   * each other by comparing the smaller number of the current index, choosing
   * the smaller of the two to go first. Repeat the process until the list is
   * sorted. */
   public static int[] mergeSort(int[] list) {
       // We have more than two elements - split then sort
       if (list.length >= 2) {
         int pivot = (int) Math.floor(list.length / 2);
         int[] halfOne = Arrays.copyOfRange(list, 0, pivot);
         int[] halfTwo = Arrays.copyOfRange(list, pivot, list.length);

         // Sort each list
         halfOne = mergeSort(halfOne);
         halfTwo = mergeSort(halfTwo);

         // Merge both lists using comparisons index-by-index
         int[] sortedList = new int[list.length];
         int indexOne = 0;
         int indexTwo = 0;
         int i = 0;
         while (i < sortedList.length) {
           if (indexOne == halfOne.length) {
             // Out of elements in halfOne, add other list
             sortedList[i] = halfTwo[indexTwo];
             indexTwo++;
             i++;
           }
           else if (indexTwo == halfTwo.length) {
             // Out of elements in HalfTwo, add other list
             sortedList[i] = halfOne[indexOne];
             indexOne++;
             i++;
           }
           else if (halfOne[indexOne] == halfTwo[indexTwo]) {
             // Elements are equal - add both
             sortedList[i] = halfOne[indexOne];
             sortedList[i + 1] = halfTwo[indexTwo];
             indexOne++;
             indexTwo++;
             i += 2;
           }
           else if (halfOne[indexOne] < halfTwo[indexTwo]) {
             // Element of halfOne is less than that of halfTwo, add first
             sortedList[i] = halfOne[indexOne];
             indexOne++;
             i++;
           }
           else {
             // Element of halfTwo is less than that of halfOne, add first
             sortedList[i] = halfTwo[indexTwo];
             indexTwo++;
             i++;
           }
         }
         return sortedList;
       }
       else {
         // One element == sorted - return it
         return list;
       }
   }
}
