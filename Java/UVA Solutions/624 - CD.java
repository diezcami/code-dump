import java.util.Scanner;

public class Main {
    public static void main (String args[]) {
        Scanner sc = new Scanner (System.in);
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            initCD (input);
        }
    }
        
    public static void initCD (String input){
        String[] tracks = input.split("\\s");
        int max = Integer.parseInt(tracks[0]) + 1;
        int length = Integer.parseInt(tracks[1]);
        
        boolean match = false;
        while (!match) {
            match = count (tracks, --max, 2, ""); // 2: start of actual tracks
        }
        
        System.out.print ("sum:" + max + "\n");
    }
    
    public static boolean count (String[] input, int sum, int index, String tracks) {  
        if (sum==0) {
            System.out.print (tracks);
            return true;
        }      
        
        if (sum!=0 && index>=input.length) 
            return false; // no match found
            
        return count (input, sum-Integer.parseInt(input[index]), index+1, tracks+input[index]+" ") ||
            count (input, sum, index+1, tracks); // Skip track
    }
}