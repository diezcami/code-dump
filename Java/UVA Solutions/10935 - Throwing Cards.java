import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main (String args[]) {
        Scanner sc = new Scanner (System.in);
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());
            if (n==0) break;
            shuffle (n);
        }
    }

    public static void shuffle (int n) {
        Queue<Integer> cards = new LinkedList<Integer>();
        String discarded = "Discarded cards:";
        int size=n;
        // init deck
        for (int i=1; i<=n; i++)
            cards.add(i);
        while (n!=1) {
            discarded += " " + cards.remove() + ",";
            cards.add(cards.remove());
            n-=1;
        }
        if (discarded.charAt(discarded.length()-1)==',')
            discarded = discarded.substring(0, discarded.length()-1);
        System.out.println (discarded + "\nRemaining card: " + cards.remove());
    }
}