// https://codeforces.com/problemset/problem/670/D2
import java.io.*;
import java.util.*;
public class MagicPowder2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long[] arr1 =new long[n];
        long[] arr2 = new long[n];

        st = new StringTokenizer(sc.nextLine());
        for (int i=0;i<n;i++){
            arr1[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(sc.nextLine());
        
        for (int i=0;i<n;i++){
            arr2[i] = Long.parseLong(st.nextToken());
        }

        long left=0,right=(long)2e9,ans=0;
        while(left <= right)
        {
            long mid = (left + right) >> 1;
            long need = 0;

            for (int i = 0; i < n && need <= k; i++){
                need += Math.max(0, arr1[i] * mid - arr2[i]);
            }
            if (need <= k) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
