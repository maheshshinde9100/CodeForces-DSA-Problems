// https://codeforces.com/problemset/problem/2181/A
import java.io.*;
import java.util.*;
public class AlphabetCity {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWritter = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] streetsArray = new String[n];
        int[][] frequency = new int[n][26];
        int[] totalfrequency = new int[26];
        
        for (int i = 0; i < n; i++) {
            streetsArray[i] = br.readLine();
            for (char c : streetsArray[i].toCharArray()) {
                frequency[i][c - 'A']++;
                totalfrequency[c - 'A']++;
            }
        }
        for (int l = 0; l < n; l++)
        {
            int k = m;
            boolean possible = true;
            for (int c = 0; c < 26; c++) {
                int totalOtherfrequency = totalfrequency[c] - frequency[l][c];
                if (totalOtherfrequency == 0){
                    if (frequency[l][c] > 0) 
                    {
                        possible = false;
                        break;
                    }
                } 
                else{
                    long numerator = (long) m * totalOtherfrequency - frequency[l][c];
                    if (numerator < 0) {
                        possible = false;
                        break;
                    }
                    int maxKForLetter = (int) (numerator / totalOtherfrequency);
                    k = Math.min(k, maxKForLetter);
                }
            }
            
            printWritter.print(possible ? k : -1);
            if (l < n - 1) printWritter.print(" ");
        }
        printWritter.println();
        printWritter.flush();
    }
}