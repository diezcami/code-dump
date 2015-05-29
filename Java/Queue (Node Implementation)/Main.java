public class Main {
    public static void main (String args[]) {
        NodeQueue birds = new NodeQueue();
        birds.enqueue ("Sparrow");
        birds.enqueue ("Lovebird");
        birds.enqueue ("Cuckoo");
        System.out.println ((String)birds.dequeue()); // Sparrow
        System.out.println ((String)birds.dequeue()); // Lovebird
        System.out.println ((String)birds.front()); // Cuckoo
        birds.enqueue ("Parrot");
        birds.enqueue ("Macau");
        birds.enqueue ("Bluejay");
        System.out.println ((String)birds.dequeue()); // Cuckoo
        System.out.println ((String)birds.dequeue()); // Parrot
        System.out.println ((String)birds.front()); // Macau
        System.out.println ((String)birds.dequeue()); // Macau
        System.out.println ((String)birds.dequeue()); // Bluejay
        System.out.println ((String)birds.dequeue()); // Exception

                        
    }
}