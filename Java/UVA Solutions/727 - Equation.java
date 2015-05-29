import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main (String args[]) {
        Scanner sc = new Scanner (System.in);
        String infix = "";
        while (sc.hasNext()) {
            String temp = sc.nextLine();
            if (!temp.equals("="))
                infix += temp;      
            else break;
        }
        convert (infix);
    }

    public static void convert (String infix) {
        Stack<Character> cs = new Stack<Character>();
        String postfix="";
    
        for (int i=0; i<infix.length(); i++) {
            if (infix.charAt(i)=='(') { // Handles Parentheses
                cs.push('(');
                
            } else if (infix.charAt(i)==')') {
                while (cs.peek()!='(')  // Input is assumed to be valid
                    postfix += String.valueOf(cs.pop()); // Adds everything between the ()
                cs.pop(); // Pops '('
                
            } else if (Character.isDigit(infix.charAt(i))) { // Handles Operands (Building up the digit)
                postfix += infix.charAt(i); // Always a single digit
                
            } else { // Handles Operators
                char temp=infix.charAt(i); 
                while (!cs.isEmpty() && topHasPrecedence(cs.peek(), temp) ) {
                    // See order method for return value details
                    postfix+=String.valueOf(cs.pop());;
                }
                cs.push(temp);                    
            }            
        }        
        // Emptying the stack
        while (!cs.isEmpty()) {
            postfix+=String.valueOf(cs.pop());
        }
        
        System.out.println(postfix + "\n");
    }
    
    static boolean topHasPrecedence (char top, char temp){ // top has equal or higher precedence over temp
        if (temp==')') {
            // Always gives top precedence unless temp is (
            if (top!='(') return true;
        } else if (top=='^') {
            // Always equal or higher precedence (ignoring )'s)
            return true;
        } else if (top=='*' || top=='/') {
            // Always equal or higher unless temp is ^
            if (temp!='^') return true;
        } else if (top=='+' || top=='-') {
            // Always lower unless temp is + or -
            if (temp=='+' || temp=='-') return true;
        } 
        
        return false;
        // if temp=='(' || top=='(' + any other operator case
    }
    
}