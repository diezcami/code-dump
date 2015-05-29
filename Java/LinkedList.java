import java.util.Scanner;

public class LLImplementation {
    private static boolean running;
    private static boolean no_init;
    private static Node top;
    
    public static void main (String args[]) {
        running=true;
        no_init=true;
        
        while (running){
            printMenu();
            Scanner sc = new Scanner (System.in);
            String s = sc.nextLine();
            switch (s) {
                case "1":
                    System.out.println ("Enter number to be added: ");
                    s = sc.nextLine(); 
                    if (no_init) {
                        top = new Node (Integer.parseInt(s), top);
                        System.out.println ("Element " + s + " has been added.");
                        no_init=false;
                    } else {                                   
                        add(Integer.parseInt(s));
                    }
                    break;
                case "2":
                    System.out.println ("Enter number to search for: ");
                    s = sc.nextLine();                
                    int result = search (Integer.parseInt(s), top);
                    if (result==1) {
                        System.out.println ("Number has been found.");
                    } else {
                        System.out.println ("Number cannot be found.");
                    }
                    break;
                case "3":
                    System.out.println ("Stored Elements:");
                    display (top);
                    break;
                case "4":
                    System.out.println ("Enter number to be removed:");
                    s = sc.nextLine();                               
                    int flag = search (Integer.parseInt(s), top);
                    if (flag==0) {
                        System.out.println ("Number cannot be found.");
                    } else {
                        // In the first element
                        if (top.getElement()==Integer.parseInt(s)) {
                            top = top.getNext();
                        } else {
                            remove (Integer.parseInt(s), top);
                        }
                    }
                    System.out.println ("Element " + s + " has been removed.");
                    break;
                case "5":
                    // Supposedly exit
                    running = false;
                    break;
            }
        }
    }
    
    static void printMenu () {
        System.out.println ("[1] Add");
        System.out.println ("[2] Search");
        System.out.println ("[3] Display");
        System.out.println ("[4] Remove");
        System.out.println ("[5] Exit");
    }
    
    static void add (int num) {
        Node temp = top;
        top = new Node (num, temp);
        System.out.println ("Element " + num + " has been added.");
    }
    
    static int search (int num, Node node) {
        if (node.getElement()==num) return 1;
        if (node.getNext()==null) return 0;
        return search (num, node.getNext());
    }
    
    static void remove (int num, Node node) {
        // Assumed to always be in the linked list
        if (node.getNext().getElement()==num) {
            node.setNext(node.getNext().getNext());
        } else {
            remove (num, node.getNext());   
        }         
    }
    
    static void display (Node node) {
        System.out.println (node.getElement());
        if (node.getNext()!=null) display(node.getNext());
    }
}

class Node {
    private int element;
    private Node next;
    
    public Node (int element, Node next) {
        this.element=element;
        this.next=next;
    }
    
    public void setElement (int element) {
        this.element = element;
    }
    
    public int getElement () {
        return element;
    }
    
    public void setNext (Node next) {
        this.next = next;
    }
    
    public Node getNext () {
        return next;
    }    
    
    public void display () {
        System.out.println (element);
    }
}