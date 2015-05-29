public interface Stack {
    public int size();
    public boolean isEmpty();
    public void push (Object o) throws FullStackException;
    public Object top() throws EmptyStackException;
    public Object pop () throws EmptyStackException;
}