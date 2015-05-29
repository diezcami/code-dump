import java.util.Scanner;

public class Main {
    private static char[][] stars;
    
    public static void main (String args[]) {
        Scanner sc = new Scanner (System.in);
        // Init Star Maps
        while (sc.hasNext()) {
            String[] count = sc.nextLine().split("\\s");
            if (count[0].equals("0")) break;
            int y = Integer.parseInt (count[0]); // rows
            int x = Integer.parseInt (count[1]); // columns
            stars = new char[y][x];            
            for (int i=0; i<y; i++) {
                String input = sc.nextLine();
                for (int j=0; j<x; j++) {
                    stars[i][j] = input.charAt(j);
                }
            }            
            count (stars);            
        }
        
    }

    public static void count (char[][] stars) {
        int count = 0;
        for (int i=0; i<stars.length; i++) { // y-coord
            for (int j=0; j<stars[0].length; j++) { // x-coord
                if (stars[i][j]=='*')
                    count+=fill(stars, i, j);
            }
        }
        
        System.out.println (count);
    }
    
    public static int fill (char[][] stars, int y, int x) {
        // Checks all perpendicular neighbors
        if (x-1>=0 && stars[y][x-1]=='*')
            return 0;
        if (x+1<stars[0].length && stars[y][x+1]=='*')
            return 0;
        if (y-1>=0 && stars[y-1][x]=='*')
            return 0;
        if (y+1<stars.length && stars[y+1][x]=='*')
            return 0;
        
        // Checks all diagonal neighbors
        if (x-1>=0 && y+1<stars.length && stars[y+1][x-1]=='*')
            return 0;
        if (x-1>=0 && y-1>=0 && stars[y-1][x-1]=='*')
            return 0;
        if (x+1<stars[0].length && y-1>=0 && stars[y-1][x+1]=='*')
            return 0;
        if (x+1<stars[0].length && y+1<stars.length && stars[y+1][x+1]=='*')
            return 0;
               
        return 1;
        // Reaching this point: No neighboring stars
    }
}