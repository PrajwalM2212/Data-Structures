package Backtracking;

public class CutRod {

    private int cutRod(int[] p, int n) {
        int q = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            q = Math.max(q, p[i] + cutRod(p, n - i));
        }
        return q;
    }
}
