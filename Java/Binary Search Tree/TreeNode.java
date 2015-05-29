public class TreeNode {
    private int key;
    private TreeNode leftChild;
    private TreeNode rightChild;
    
    public TreeNode (int key) {
        this.key=key;
    }
    
    public void display() {
        System.out.println (key);
    }
    
    public void setKey (int key) {
        this.key = key;
    }
    
    public int getKey () {
        return key;
    }    
    
    public void setRightChild (TreeNode rightChild) {
        this.rightChild = rightChild;
    }
    
    public void setLeftChild (TreeNode leftChild) {
        this.leftChild = leftChild;
    }
    
    public TreeNode getRightChild () {
        return rightChild;
    }
    
    public TreeNode getLeftChild () {
        return leftChild;
    }
}