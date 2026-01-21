// https://codeforces.com/problemset/problem/977/C
import java.util.*;
public class LessOrEqual {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++)
        {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        if(k==0){
            if (a[0] > 1) {
                System.out.println(1);
            } else {
                System.out.println(-1);
            }
            return;
        }
        if(k==n){
            System.out.println(a[n - 1]);
            return;
        }
        int leftt = k - 1;
        int right = k;

        if(a[leftt]==a[right])
        {
            System.out.println(-1);
        } else {
            System.out.println(a[leftt]);
        }
    }
}
