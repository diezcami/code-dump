public class CharStack implements Stack {
    private int top;
    private int capacity;
    private Character[] S;
    
    public CharStack (int capacity){
        top=-1;
        this.capacity=capacity;
        S=new Character[capacity];
    }

    public int size(){
        return top+1;
    }
    
    public boolean isEmpty(){
        return top<0;
    }
    
    public void push(Object o) throws FullStackException {
        if (size()==capacity) throw new FullStackException();
        S[++top]=(Character)o;        
    }
    
    public Character top() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return S[top];
    }
    
    public Character pop () throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        Character temp=S[top];
        S[top--]=null;
        return temp;
    }
}

