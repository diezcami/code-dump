import java.util.*;
public class Recursion {
    public static void main (String args[]) {
         System.out.println(why ("2[34]", 4, 4));
    }
    
    // Recursive Fibonacci
    public static int fib (int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        return fib(n-2) + fib(n-1);
    }
    
    // Splitting a numerical string "str" until its sum equals int "sum" (two addends only)
    public static boolean splitsplit (String str, int sum, int index) { // Start at 1
        if (index>=str.length()) return false;
        if (Integer.parseInt(str.substring(0,index)) + Integer.parseInt(str.substring(index)) == sum) return true;
        return splitsplit (str, sum, index+1);
    }
    
    // Checking if a string is properly nested
    public static String why (String str, int start, int end) { // Start and End = str.length()
        if (start<0 && end<0) return str; // Stop forever
        
        // Check for nests
        if (str.charAt(start)=='[' && str.charAt(end)==']' ) {
        
            if (Integer.parseInt(str.substring(start+1,end+1))%2==0) { //even
                str = str.substring(0, start) + str.substring(start+1, end) + str.substring(start-1, start) + str.substring(end);
                return why (str, str.length()-1, str.length()-1);
            } else { //odd
                str = str.substring(0, start-1) + str.substring(start-1, start) + str.substring(start+1, end) + str.substring(start-1, start) + str.substring(end);
                return why (str, str.length()-1, str.length()-1);
            }
            
        }
        
        if (str.charAt(end)!=']' && end !=0) return why (str, start, end-1);
        return why (str, start-1, end);
    }
}
