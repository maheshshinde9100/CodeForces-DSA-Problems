// https://codeforces.com/problemset/problem/363/B
import java.util.Scanner;
public class Fence{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] h = new int[n];
        for(int i = 0; i < n; i++)
        {
            h[i] = sc.nextInt();
        }

        int windowSum = 0;
        for(int i=0;i<k;i++)
       {
            windowSum += h[i];
        }

        int minimumSum = windowSum;
        int minIndex = 0;
        for(int i=k;i<n;i++){
            windowSum += h[i]; 
            windowSum -=h[i-k];

            if(windowSum < minimumSum){
                minimumSum = windowSum;
                minIndex = i-k+1;
            }
        }
        System.out.println(minIndex + 1);
    }
}