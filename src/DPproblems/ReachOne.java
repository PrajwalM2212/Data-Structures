package DPproblems;

public class ReachOne {

    /*
    I will this as a type - 2 DP problem.
     */


    // top-down dp

    private int solve(int n, int[] cache) {

        if (cache[n] != 0) {
            return cache[n];
        }

        if (n == 1) {
            return 0;
        }

        int a = 1 + solve(n - 1, cache);

        int b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;

        if (n % 2 == 0) {
            b = 1 + solve(n / 2, cache);
        }

        if (n % 3 == 0) {
            c = 1 + solve(n / 3, cache);
        }

        return cache[n] = Math.min(a, Math.min(b, c));

    }

    // bottom-up DP

    private int solve2(int n, int[] cache) {

        cache[1] = 0;

        for (int i = 2; i <= n; i++) {

            int a = 1 + cache[i - 1];
            int b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;
            if (i % 2 == 0) {
                b = 1 + cache[i / 2];
            }

            if (i % 3 == 0) {
                c = 1 + cache[i / 3];
            }

            cache[i] = Math.min(a, Math.min(b, c));
        }

        return cache[n];
    }


    public static void main(String[] args) {
        System.out.println(new ReachOne().solve(12, new int[13]));
        System.out.println(new ReachOne().solve2(12, new int[13]));
    }


}
