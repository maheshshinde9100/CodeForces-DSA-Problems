// https://codeforces.com/problemset/problem/118/B
import java.util.*;
public class PresentFromLena {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i <= 2 * n; i++) {
            int dist = Math.abs(n - i);
            int max = n - dist;
            for(int s=0;s<dist*2;s++)
            {
                System.out.print(" ");
            }
            for(int num=0;num<=max;num++)
            {
                if (num > 0) System.out.print(" ");
                System.out.print(num);
            }
            for(int num=max-1;num>=0;num--)
            {
                System.out.print(" ");
                System.out.print(num);
            }
            System.out.println();
        }
        scanner.close();
    }
}
