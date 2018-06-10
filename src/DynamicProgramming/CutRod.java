package DynamicProgramming;

public class CutRod {


    private int memoizedCut(int[] p, int n) {

        int[] r = new int[n];
        for (int i = 0; i <= n; i++) {
            r[i] = Integer.MIN_VALUE;
        }
        return memoizedCutAux(p, n, r);
    }

    private int memoizedCutAux(int[] p, int n, int[] r) {

        int q;
        if (r[n] >= 0) {
            return r[n];
        }
        if (n == 0) {
            q = 0;
        } else {
            q = Integer.MIN_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            q = Math.max(q, p[i] + memoizedCutAux(p, n - i, r));
        }
        r[n] = q;
        return q;
    }


}
