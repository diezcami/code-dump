public class NodeQueue implements Queue {
    private int size;    
    private Node front;
    private Node rear;
    
    public NodeQueue () {
        front=null;
        rear=null;
        size=0;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public Object front() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException();
        return front.getElement();
    }
    
    public void enqueue (Object input) {
        Node temp = new Node (input, null);
        rear.setNext(temp);
        rear=temp; // This
        size++;
    }
    
    public Object dequeue () throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException();
        
        Object temp=front.getElement();
        front=front.getNext(); // Null if it's the last one
        size--;
        // if (isEmpty()) rear=null; // For Practice
        return temp;
    }
    
    public void display () {
        // Code
    }
}