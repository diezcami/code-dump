/* 
    This code uses an alternative approach to flood fill problems as opposed to the
    methods found in 871-counting-cells and 11244-counting-stars. The problem being solved,
    however is pretty different in context.
*/

import java.util.*;
import java.lang.StringBuilder;
import java.io.*;

public class Main {
    public static void main (String args[]) throws IOException{
        // Usual Setup
        BufferedReader br = new BufferedReader (new FileReader ("input.in.txt"));
        StringBuilder sb = new StringBuilder("");
        int t = Integer.parseInt (br.readLine());
        int count = 1;
        String output = "";
        
        // Case Parsing
        while (t>0) {
            int n = Integer.parseInt (br.readLine());
            int m = Integer.parseInt (br.readLine());
            
            char[][] map = new char[n][m];
            int[][] visited = new int[n][m]; // init: all 0
            String armies = "";
            
            // Map Parsing
            int l = 0;
            while (l<n) {
                int index = 0;
                String temp = br.readLine();
                for (int i=0; i<m; i++) {
                    char x = temp.charAt(i);
                    map[l][index++] = x;
                    // For alphabetising armies later
                    if (x!='#' && x!='.')
                        armies += x;    
                }
                l++;
            }
            
            
            // Sorting armies   
            char[] sortedArmies = parseArmy (armies);
            LinkedHashMap<String, Integer> armyCaptures = new LinkedHashMap();
            
            for (char x : sortedArmies)
                armyCaptures.put ("" + x, 0);
            armyCaptures.put ("contested", 0);
            // Exploring Map, Gathering Data
            for (int i=0; i<n; i++) { // Height
                for (int j=0; j<m; j++) { // Width
                    if (map[i][j]!='#') {
                        String temp = explore (i, j, map, visited, "");
                        
                        if (temp.length()==1)
                            armyCaptures.put(temp, (int)armyCaptures.get(temp)+1);
                        else if (temp.length()>1)
                            armyCaptures.put("contested", (int)armyCaptures.get("contested")+1);
                            
                    }
                }
            }
            
            // Fixing Output String
            sb.append ("Case " + count + ":");
            count++;
            
            Set set = armyCaptures.entrySet();
            Iterator i = set.iterator();
            
            while (i.hasNext()) {
                Map.Entry e = (Map.Entry)i.next();
                if (e.getValue() != 0 || e.getKey().equals("contested"))
                    sb.append ("\n" + e.getKey() + " " + e.getValue());
            }
            
            if (t!=1)
                sb.append("\n");    
            
            t--;
        }
        
        
        System.out.println (sb.toString());
             
    }
    
    public static String explore (int y, int x, char[][] map, int[][] visited, String armies) {
        if ((x>=0 && y>=0 && x<map[0].length && y<map.length) && // Area is valid
            (map[y][x]!='#' && visited[y][x]==0)) {
            if (map[y][x]!='.' && armies.lastIndexOf(map[y][x])==-1)
                armies += map[y][x];
            visited[y][x] = 1;
        
            armies = explore (y+1, x, map, visited, armies);
            armies = explore (y, x+1, map, visited, armies);
            armies = explore (y-1, x, map, visited, armies);
            armies = explore (y, x-1, map, visited, armies);
        }
    
        return armies;
    }
    
    public static char[] parseArmy (String armies) {
        String sortedArmies = "";
        char[] temp = armies.toCharArray();
        
        if (temp.length==0)
            return temp;
            
        Arrays.sort(temp);
        for (int i=0; i<temp.length - 1; i++) {
            if (temp[i] != temp[i+1])
                sortedArmies += temp[i];
        }
        
        sortedArmies += temp[temp.length-1];
        
        return sortedArmies.toCharArray();
    }
    

}
