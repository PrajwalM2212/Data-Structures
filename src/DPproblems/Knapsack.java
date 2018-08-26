package DPproblems;

public class Knapsack {

    private int[] values;
    private int[] weights;
    private int W;
    private int count = 0;


    private int solve(int weight, int n, int[][] cache) {


        if (cache[weight][n] != 0) {
            return cache[weight][n];
        }

        count++;

        if (weight > W) {
            return cache[weight][n] = -1000;
        }

        if (n == values.length) {
            return cache[weight][n] = 0;
        }

        if (weight == W) {
            return cache[weight][n] = 0;
        }


        return cache[weight][n] = Math.max(values[n] + solve(weight + weights[n], n + 1, cache), solve(weight, n + 1, cache));

    }


    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        knapsack.values = new int[]{60, 100, 120, 120, 30, 46};
        knapsack.weights = new int[]{10, 20, 30, 40, 50, 60};
        knapsack.W = 100;
        System.out.println(knapsack.solve(0, 0, new int[500][7]));
        System.out.println("Number of recursive calls " + knapsack.count);
    }
}
