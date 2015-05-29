import java.util.Scanner;
import java.util.Arrays;

public class SortingAlgorithms {

    public static void main (String args[]) {
        int[] A = new int[]{7, 9, 1, 0, 2, 4, -19, -12, 93, 18};
        mergeSplit(A);
        for (int i:A) System.out.println(i);
    }
    
    static int binarySearch_R (int[] A, int key, int start, int end) { // start:0 &end: A.length()/2
        if (start>end) return -1;
        int mid = (start+end)/2;
        if (key>A[mid]) return binarySearch_R (A, key, mid+1, end);
        else if (key<A[mid]) return binarySearch_R (A, key, start, mid-1);
        return mid;
    }
    
    static void insertionSort (int[] A) {
        for (int i=1; i<A.length; i++) {
            int temp = A[i];
            int j=i;
            while (j>0 && A[j-1] > temp) {
                A[j] = A[j-1];
            }
            A[j] = temp;
        }
    }
    
    static void quickSort (int[] A, int left, int right) {
          int index=quickSort_H(A, left, right);
          if (left<index-1) quickSort(A, left, index-1);
          if (index>right) quickSort(A, index, right);
    }
    
    static int quickSort_H (int[] A, int left, int right) { // Divide
        int pivot = A[left];
        int start=left;
        int end=right;
        
        while (start<=end) {
            while (A[start]<pivot) start++;
            while (A[end]>pivot) end--;
            
            if (start<=end) { // Left Counter>Right Counter
                int temp = A[start];
                A[start] = A[end];
                A[end] = temp;
                start++;
                end--;
            }
            
        }
        return left;
    }
 
    
}