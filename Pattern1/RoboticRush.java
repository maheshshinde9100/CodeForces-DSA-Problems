// https://codeforces.com/problemset/problem/2185/E
import java.util.*;

public class RoboticRush {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            HashSet<Long> robots = new HashSet<>();
            for (int i = 0; i < n; i++) {
                robots.add(sc.nextLong());
            }

            HashSet<Long> spikes = new HashSet<>();
            for (int i = 0; i < m; i++) {
                spikes.add(sc.nextLong());
            }

            String instructions = sc.next();

            long displacement = 0;
            int alive = n;
            StringBuilder ans = new StringBuilder();

            for (int i = 0; i < k; i++) {
                char c = instructions.charAt(i);
                displacement += (c == 'L') ? -1 : 1;

                ArrayList<Long> dead = new ArrayList<>();
                if(robots.size()<=spikes.size()){
                    for(long r:robots){
                        if(spikes.contains(r + displacement))
                        {
                            dead.add(r);
                        }
                    }
                }
                else{
                    for(long s : spikes)
                    {
                        long r = s - displacement;
                        if (robots.contains(r)) {
                            dead.add(r);
                        }
                    }
                }

                for(long r : dead)
                {
                    robots.remove(r);
                    alive--;
                }
                ans.append(alive).append(" ");
            }
            System.out.println(ans.toString().trim());
        }
        sc.close();
    }
}
