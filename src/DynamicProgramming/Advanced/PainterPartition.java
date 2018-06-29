package DynamicProgramming.Advanced;

import java.util.Scanner;

public class PainterPartition {

    private int solve(int sum, int k, int n) {

        System.out.println("sum = " + sum);
        int[][] cache = new int[sum + 1][k + 1];

        // time required by one painter to paint i units is i
        for (int i = 1; i <= sum; i++) {
            cache[i][1] = i;
        }

        // j is number of painters
        for (int j = 2; j <= k; j++) {
            // time taken by j painters to paint one unit is 1
            cache[1][j] = 1;
            // calculate time taken by j painters to paint i units
            for (int i = 2; i <= sum; i++) {
                int min = Integer.MAX_VALUE;
                // check for all partitions of i
                for (int d = 1; d < i; d++) {
                    min = Math.min(min, Math.max(d, cache[i - d][j - 1]));
                }
                cache[i][j] = min;
                System.out.println(i + " " + j + "=" + cache[i][j]);
            }
        }

        return cache[sum][k];

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + scanner.nextInt();
        }
        int k = scanner.nextInt();
        PainterPartition partition = new PainterPartition();
        System.out.println(partition.solve(sum, k, n));

    }
}
