/*(https://codeforces.com/problemset/problem/2184/G)*/
import java.util.*;
public class NastinessOfSegments {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int nastiness = 0;
        for (int i = 0; i < n - 1; i++) {
            nastiness += Math.abs(arr[i] - arr[i + 1]);
        }
        int maxReduction = 0;
        for (int i = 0; i < n; i++) {
            int originalContribution = 0;
            int newContribution = 0;
            if (i > 0) {
                originalContribution += Math.abs(arr[i] - arr[i - 1]);
                newContribution += Math.abs(arr[i - 1] - (i + 1 < n ? arr[i + 1] : arr[i - 1]));
            }
            if (i < n - 1) {
                originalContribution += Math.abs(arr[i] - arr[i + 1]);
                newContribution += Math.abs((i > 0 ? arr[i - 1] : arr[i + 1]) - arr[i + 1]);
            }
            int reduction = originalContribution - newContribution;
            maxReduction = Math.max(maxReduction, reduction);
        }
        System.out.println(nastiness - maxReduction);
    }
}