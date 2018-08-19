package DPproblems;

public class Change {

    // top-down DP
    private int solve(int n, int[] coins, int[] cache) {

        if (cache[n] != 0) {
            return cache[n];
        }

        int k = 10000;

        if (n == 0) {
            return 0;
        }


        for (int i = 0; i < coins.length; i++) {


            if (n >= coins[i]) {
                k = Math.min(k, 1 + solve(n - coins[i], coins, cache));
            }


        }


        return cache[n] = k;

    }


    // bottom-up DP

    private int solve2(int n, int[] coins, int[] cache) {

        cache[0] = 0;
        for (int e : coins) {
            cache[e] = 1;
        }


        for (int i = 1; i <= n; i++) {
            int k = 10000;
            if (cache[i] == 0) {

                for (int coin : coins) {
                    if (coin <= i) {
                        k = Math.min(k, 1 + cache[i - coin]);
                    }
                }

                cache[i] = k;

            }


        }

        return cache[n];
    }

    public static void main(String[] args) {

        System.out.println(new Change().solve(120, new int[]{2, 4, 3}, new int[121]));
        System.out.println(new Change().solve2(120, new int[]{2, 4, 3}, new int[121]));
    }


}
