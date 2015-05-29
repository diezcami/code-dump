public class DoubleStack implements Stack {
    private int top;
    private int capacity;
    private Double[] S;
    
    public DoubleStack (int capacity){
        top=-1;
        this.capacity=capacity;
        S=new Double[capacity];
    }

    public int size(){
        return top+1;
    }
    
    public boolean isEmpty(){
        return top<0;
    }
    
    public void push(Object o) throws FullStackException {
        if (size()==capacity) throw new FullStackException();
        S[++top]=(Double)o;        
    }
    
    public Double top() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return S[top];
    }
    
    public Double pop () throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        Double temp=S[top];
        S[top--]=null;
        return temp;
    }
    
}

