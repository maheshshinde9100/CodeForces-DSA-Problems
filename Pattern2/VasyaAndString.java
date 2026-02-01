//https://codeforces.com/problemset/problem/676/C
import java.io.*;
import java.util.*;
public class VasyaAndString {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        int l = 0;
        int countOfA = 0, countOfB = 0;
        int max = 0;

        for(int r=0;r<n;r++)
        {
            if(s.charAt(r) == 'a')
            {
                countOfA++;
            } else {
                countOfB++;
            }
            while((r-l+1) - Math.max(countOfA,countOfB)>k){
                if(s.charAt(l) == 'a')
                {
                    countOfA--;
                }
                else{
                    countOfB--;
                }
                l++;
            }

            max = Math.max(max,r-l+1);
        }

        System.out.println(max);
    }
}
