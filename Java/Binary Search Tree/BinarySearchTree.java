import java.io.InputStreamReader;
import java.util.Scanner;
import java.lang.NumberFormatException;

public class BinarySearchTree {
    TreeNode root;
    
    public void run() {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        char key = '*';
        while(key != '5') {
            System.out.println("[1] Insert");
            System.out.println("[2] Search");
            System.out.println("[3] Delete");
            System.out.println("[4] In-order Traversal");
            System.out.println("[5] Exit");
            System.out.print("Enter choice: ");
			
	    String a = sc.nextLine();
	    if(a.length() != 1) key = '0';
	    else key = a.charAt(0);
				
            switch(key) {
                case '1': System.out.print ("[INSERT] Enter Key: ");
                          try {
                            searchInsert (Integer.parseInt(sc.nextLine()), true);
                          } catch (NumberFormatException e) {
                            System.out.println ("[ERROR]: Not a valid integer");
                          };
                          break;
                case '2': System.out.print ("[SEARCH] Enter Key: ");
                          try {
                            searchInsert (Integer.parseInt(sc.nextLine()), false);
                          } catch (NumberFormatException e) {
                            System.out.println ("[ERROR]: Not a valid integer");
                          };
                          break;
                case '3': System.out.print ("[DELETE] Enter Key: ");
                          try {
                            delete (Integer.parseInt(sc.nextLine()));
                          } catch (NumberFormatException e) {
                            System.out.println ("[ERROR]: Not a valid integer");
                          };                                                   
                          break;
                case '4': inOrderTraverse(root);
                          break;
                case '5': break;
		        case '\n': System.out.println();
			              break;
                default: System.out.println("Invalid choice! \n");
            }
        }
    }

    // Used for both the search and insert method
    // Parameter Insert = True if Node will be inserted
    //                  = False if only the search function will be used
    public void searchInsert (int key, boolean insert) {
        if (root==null) {
            if (insert) {
                TreeNode temp = new TreeNode (key);
                root = temp;
                System.out.printf ("TreeNode with key %d has been inserted.%n", key);
                return;
            } else {
                System.out.println ("The tree is empty.");
                return;
            }
        }        
        TreeNode pointer = root;
        TreeNode parent = root;
        boolean isLeftChild = true;

        while (pointer.getKey()!=key) {
            parent = pointer;
            if (key < pointer.getKey()) { // Check left children
                pointer = pointer.getLeftChild();
                isLeftChild = true;
            } else { 
                pointer = pointer.getRightChild();
                isLeftChild = false;
            }
            
            if (pointer==null) {
                if (!insert) { // Search method ends if it's found
                    System.out.printf ("TreeNode with key %d cannot be found.%n", key);
                    return;
                } else { // Insert Function
                    TreeNode temp = new TreeNode (key);
                    System.out.printf ("TreeNode with key %d has been inserted.%n", key);                    
                    if (isLeftChild) {
                        parent.setLeftChild (temp);
                        return;
                    } else {
                        parent.setRightChild (temp);
                        return;
                    }
                }
            }
        }     
        // This point is reached if the node is not unavailable
        if (insert) // Insert Outcome
            System.out.printf ("[ERROR]: TreeNode with key %d is already in use.%n", key);
        else // Search Outcome
            System.out.printf ("TreeNode with key %d has been found.%n", key);
    }
    
    // "Display" methods
    public void inOrderTraverse (TreeNode pointer) {
        if (root==null) {
            System.out.println ("The tree is empty.");
            return;
        }    
    
        if (pointer!=null) {
            inOrderTraverse (pointer.getLeftChild());
            pointer.display();
            inOrderTraverse (pointer.getRightChild());
        }
    }
         
    public void delete (int key) {
        if (root==null) {
            System.out.println ("The tree is empty.");
            return;
        }    
    
        TreeNode pointer = root; //start
        TreeNode parent = root;                
        boolean isLeftChild = true;
        
        // Search Function
        while (pointer.getKey() != key) {
            parent = pointer;
            if (key < pointer.getKey()) {
                pointer = pointer.getLeftChild();
                isLeftChild = true;
            } else {
                pointer = pointer.getRightChild();
                isLeftChild = false;
            }
            
            if (pointer==null) {
                System.out.printf ("TreeNode with key %d cannot be found.%n", key);
                return;
            }
        }
        
        // Pointer key matches input key at this point
        // Barren parent
        if (pointer.getLeftChild() == null && pointer.getRightChild() == null) {
            if (pointer==root)
                root = null;
            else if (isLeftChild) 
                parent.setLeftChild (null);
            else //right child
                parent.setRightChild (null);
        
        // Has a right child
        } else if (pointer.getLeftChild() == null) {
            if (pointer==root)
                root = pointer.getRightChild();
            else if (isLeftChild)
                parent.setLeftChild (pointer.getRightChild());
            else //right child
                parent.setRightChild (pointer.getRightChild());
                
        // Has a left child
        } else if (pointer.getRightChild() == null) {
            if (pointer==root)
                root = pointer.getLeftChild();
            else if (isLeftChild)
                parent.setLeftChild (pointer.getLeftChild());
            else //right child
                parent.setRightChild (pointer.getLeftChild());
    
        // Has two children
        } else {
            TreeNode replacementParent = findMinimumParent (pointer.getRightChild());
            pointer.setKey (replacementParent.getLeftChild().getKey());
            replacementParent.setLeftChild(replacementParent.getLeftChild().getRightChild());
        }   
        
        System.out.printf ("TreeNode with key %d has been removed.%n", key);          
    }        
        
    // Returns parent of the minimum TreeNode in a sub tree with root 'pointer'
    public TreeNode findMinimumParent (TreeNode pointer) {
        if (pointer.getLeftChild().getLeftChild() != null)
            return findMinimumParent (pointer.getLeftChild());        
        return pointer;
    }
        
    public static void main (String args[]) {
        BinarySearchTree bt = new BinarySearchTree ();
        bt.run();                                                                      
    }   
}