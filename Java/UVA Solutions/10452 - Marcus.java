import java.util.Scanner;

public class Main {
    public static void main (String args[]) {
        Scanner sc = new Scanner (System.in);
        char[] keys = new char[]{'I', 'E', 'H', 'O', 'V', 'A', '#'};
        int cases = Integer.parseInt(sc.nextLine()); // # of test cases
        while (cases!=0) {
            String[] count = sc.nextLine().split("\\s"); // length and width
            int y = Integer.parseInt(count[0]);
            int x = Integer.parseInt(count[1]);
            char[][] map = new char[y][x];
            int start = 0;
            // fills map
            for (int i=0; i<y; i++) {
                String temp = sc.nextLine();
                for (int j=0; j<x; j++) {
                    if (i==y-1 && temp.charAt(j)=='@')
                        start = j;
                    map[i][j] = temp.charAt(j);
                }
            }
            
            getDirections (map, y-1, start, keys, 0, "");
            cases-=1;
        }                                                                                               
    }
    
    public static void getDirections (char[][] map, int y, int x, char[] keys, int key, String trail) {
        if (key>=keys.length) {
            System.out.println (trail.substring(0, trail.length()-1)); // Removes last space
            return;
        }
    
        if (x-1>=0 && map[y][x-1]==keys[key]) {
            trail+="left ";
            getDirections (map, y, x-1, keys, key+1, trail);
            
        } else if (x+1<map[0].length && map[y][x+1]==keys[key]) {
            trail+="right ";
            getDirections (map, y, x+1, keys, key+1, trail);
            
        } else if (y-1>=0 && map[y-1][x]==keys[key]) {
            trail+="forth ";
            getDirections (map, y-1, x, keys, key+1, trail);
        }
    }
}