// https://codeforces.com/problemset/problem/34/B
import java.util.*;
public class Sale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n;i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int ans = 0;
        for(int i=0;i<m;i++){
            if(arr[i]<0){
                ans += -arr[i];
            } else {
                break;
            }
        }

        System.out.println(ans);
        scanner.close();
    }
}
