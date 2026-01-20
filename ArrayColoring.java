import java.util.*;

public class ArrayColoring {
    static boolean dfs(int u, int col, int[] a, int[] p, int[] c) {
        if (c[u] != 0) return c[u] == col;
        c[u] = col;
        int n = a.length, v = a[u];
        if ((u > 0 && !dfs(u - 1, -col, a, p, c)) || 
            (u < n - 1 && !dfs(u + 1, -col, a, p, c)) ||
            (v > 1 && !dfs(p[v - 1], -col, a, p, c)) || 
            (v < n && !dfs(p[v + 1], -col, a, p, c))) 
            return false;
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = sc.nextInt(); t-- > 0;) {
            int n = sc.nextInt();
            int[] a = new int[n], p = new int[n + 2], c = new int[n];
            for (int i = 0; i < n; i++) p[a[i] = sc.nextInt()] = i;
            boolean ok = true;
            for (int i = 0; i < n && ok; i++) 
                if (c[i] == 0) ok = dfs(i, 1, a, p, c);
            System.out.println(ok ? "YES" : "NO");
        }
    }
}