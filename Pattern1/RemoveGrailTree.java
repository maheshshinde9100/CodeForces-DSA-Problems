import java.io.*;
import java.util.*;

public class RemoveGrailTree {
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();

            int[] a = new int[n];
            int[] pa = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
                pa[i] = a[i] & 1;
            }

            ArrayList<Integer>[] g = new ArrayList[n];
            for (int i = 0; i < n; i++) g[i] = new ArrayList<>();

            for (int i = 0; i < n - 1; i++) {
                int u = fs.nextInt() - 1;
                int v = fs.nextInt() - 1;
                g[u].add(v);
                g[v].add(u);
            }

            int[] deg = new int[n];
            int[] ps = new int[n];

            for (int i = 0; i < n; i++) {
                deg[i] = g[i].size();
                for (int to : g[i]) {
                    ps[i] ^= pa[to];
                }
            }

            boolean[] removed = new boolean[n];
            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if (pa[i] != ps[i]) q.add(i);
            }

            List<Integer> order = new ArrayList<>();

            while (!q.isEmpty()) {
                int v = q.poll();
                if (removed[v]) continue;

                removed[v] = true;
                order.add(v + 1);

                for (int u : g[v]) {
                    if (removed[u]) continue;
                    deg[u]--;
                    ps[u] ^= pa[v];
                    if (pa[u] != ps[u]) {
                        q.add(u);
                    }
                }
            }

            if (order.size() == n) {
                out.append("YES\n");
                for (int x : order) out.append(x).append(' ');
                out.append('\n');
            } else {
                out.append("NO\n");
            }
        }

        System.out.print(out);
    }
}
