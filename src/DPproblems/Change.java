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


    public static void main(String[] args) {

        System.out.println(new Change().solve(100, new int[]{2, 4, 3}, new int[101]));

    }


}
