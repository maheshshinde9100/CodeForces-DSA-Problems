// https://codeforces.com/problemset/problem/2185/E
import java.util.*;

public class RoboticRush {
    static final int INF = (int)1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            long[] robots = new long[n];
            for (int i = 0; i < n; i++) robots[i] = sc.nextLong();

            long[] spikes = new long[m];
            for (int i = 0; i < m; i++) spikes[i] = sc.nextLong();

            String s = sc.next();

            int[] disp = new int[k + 1];
            for (int i = 1; i <= k; i++) {
                disp[i] = disp[i - 1] + (s.charAt(i - 1) == 'L' ? -1 : 1);
            }

            HashMap<Integer, Integer> first = new HashMap<>();
            for (int i = 0; i <= k; i++) {
                first.putIfAbsent(disp[i], i);
            }

            Arrays.sort(robots);
            Arrays.sort(spikes);

            // deathTime[i] = step when robot i dies
            int[] deathTime = new int[n];
            Arrays.fill(deathTime, INF);

            for (Map.Entry<Integer, Integer> e : first.entrySet()) {
                int d = e.getKey();
                int time = e.getValue();

                int i = 0, j = 0;
                while (i < n && j < m) {
                    long want = robots[i] + d;
                    if (want == spikes[j]) {
                        deathTime[i] = Math.min(deathTime[i], time);
                        i++; j++;
                    } else if (want < spikes[j]) {
                        i++;
                    } else {
                        j++;
                    }
                }
            }

            int[] diedAt = new int[k + 2];
            for (int i = 0; i < n; i++) {
                if (deathTime[i] <= k) {
                    diedAt[deathTime[i]]++;
                }
            }

            int alive = n;
            StringBuilder out = new StringBuilder();
            for (int i = 1; i <= k; i++) {
                alive -= diedAt[i];
                out.append(alive).append(" ");
            }
            System.out.println(out.toString().trim());
        }

        sc.close();
    }
}
