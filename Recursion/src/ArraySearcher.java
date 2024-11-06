/* ArraySearcher.java 
 * binarySearch method uses recursion to search an array of integers,
 * which must be already sorted.
 * adapted from Listing 11.6 in Java by Savitch
 * to compare linear search and binary search.
 */

import java.util.Arrays;
import java.util.Scanner;

public class ArraySearcher {
    private int[] a;
    public int count;
    
    /* linear search method for finding target key in an integer array
     * returns the index of an occurrence of target in list,
     * or returns -1 if target is not in the array.
     */
    public int linearSearch(int[] list, int target) {
        count = 0;
        for (int i = 0; i < list.length; i++) {
            count++;
            if (target == list[i])
                return i;
        }
        return -1;
    }
    
    /* Precondition: For binary search, theArray is full and is sorted
     * from lowest to highest.
     */
    public ArraySearcher(int[] theArray) {
        a = theArray; //a is now the private name for theArray.
    }
    
    /* If target is in the array, returns the index of an occurrence
     * of target. Returns -1 if target is not in the array.
     */
    public int find(int target) {
        count = 0;
        int result;
        result = binarySearch(target, a, 0, a.length - 1);
        System.out.println("count of calls to binarySearch: " + count);
        return result;
    }
    
    // Uses binary search to search for target in a[first] through
    // a[last] inclusive. Returns the index of target if target
    // is found. Returns -1 if target is not found. 
    private int binarySearch(int target, int[] a, int first, int last) {
        int result;
        count++;
        if (first > last)         // base case: failure
            result = -1;
        else {
            int mid = (first + last) / 2;
            if (target == a[mid]) // base case: success
                result = mid; 
            else if (target < a[mid])
                result = binarySearch(target, a, first, mid - 1);
            else // we know (target > a[mid])
                result = binarySearch(target, a, mid + 1, last);
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int size = keyboard.nextInt();
        int [] anArray = new int[size];
        
        // initialize anArray with size elements
        // set each element to a random value between 0 and size
        for (int i = 0; i < size; i++) {
            int num = (int)(Math.random() * size);
            anArray[i] = (int)(Math.random()*100000);
        }
        // sort the array using library method
        Arrays.sort(anArray);
        printArray(anArray);
        
        ArraySearcher finder = new ArraySearcher(anArray);
        String ans;
        do {
            System.out.println("Enter a value to search for:");
            int target = keyboard.nextInt( );     
            
            long start = System.nanoTime();
            int resultLinear = finder.linearSearch(anArray, target);
            long end = System.nanoTime();
            System.out.println("Found value at element " + resultLinear);
            System.out.println("Linear Search comparisons = " + finder.count);
            System.out.println("Linear Search Time: " + (end - start) + " ns ");
            
            start = System.nanoTime();
            int result = finder.find(target);
            end = System.nanoTime();
            if (result < 0)
                System.out.println(target + " is not in the array.");
            else
                System.out.println(target + " is at index " + result);
            System.out.println("Binary Search comparisons = " + finder.count);
            System.out.println("Binary Search Time: " + (end - start) + " ns ");
            
            System.out.println("Search again? (yes or no)");
            ans = keyboard.next( );
        } while (ans.equalsIgnoreCase("yes"));
        System.out.println("May you find what you're searching for.");
    }
    
    /* printArray shows contents of array with positions */
    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print("a[" + i + "]=" + a[i] + " ");
        System.out.println("\n");
    }
}