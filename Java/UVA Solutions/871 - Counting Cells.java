import java.util.Scanner;

public class Main {
    public static void main (String args[]) {
        Scanner sc = new Scanner (System.in);
        int cases = Integer.parseInt(sc.nextLine()); // # of test cases
        sc.nextLine(); // Empty Line
        
        while (cases!=0) {
            int[][] map = new int[25][25]; // init: [0]
            int y=0;
            int x=0;
            boolean noEmptyLines=true;
            
            while (noEmptyLines) {
                String temp = sc.nextLine();
                if (temp.isEmpty()) {
                    noEmptyLines=false; // Empty line
                    break;
                }
                x = temp.length();
                for (int i=0; i<x; i++)
                    map[y][i] = Character.getNumericValue(temp.charAt(i)); 
                y+=1;               
            }
            
            int max = 0;
            for (int i=0; i<y; i++) {
                for (int j=0; j<x; j++) {
                    if (map[i][j]==1) {
                        int count = largestBlob (map, i, j, 0);
                        if (count>max)
                            max = count;
                    }
                }
            }
            System.out.println (max);
            cases-=1;
        }                                                                                               
    }
    
    public static int largestBlob (int[][] map, int y, int x, int count) {
        map[y][x] = 0; // Can't revisit
        count+=1;
        // Check perpendicular sides
        if (x-1>=0 && map[y][x-1]==1)
            count = largestBlob (map, y, x-1, count);
        if (x+1<map[0].length && map[y][x+1]==1)
            count = largestBlob (map, y, x+1, count);
        if (y-1>=0 && map[y-1][x]==1)
            count =largestBlob (map, y-1, x, count);
        if (y+1<map.length && map[y+1][x]==1)
            count =largestBlob (map, y+1, x, count);   
                 
        // Check diagonal sides
        if (x-1>=0 && y-1>=0 && map[y-1][x-1]==1)
            count =largestBlob (map, y-1, x-1, count);
        if (x+1<map[0].length && y-1>=0 && map[y-1][x+1]==1)
            count =largestBlob (map, y-1, x+1, count);
        if (x-1>=0 && y+1<map.length && map[y+1][x-1]==1)
            count =largestBlob (map, y+1, x-1, count);
        if (x+1<map[0].length && y+1<map.length && map[y+1][x+1]==1)
            count =largestBlob (map, y+1, x+1, count);          
        
        return count; // Reaches here if surrounded by 0's; "base case"
    }
}