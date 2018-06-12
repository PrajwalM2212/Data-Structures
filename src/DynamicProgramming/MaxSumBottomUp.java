package DynamicProgramming;

import java.util.Scanner;

public class MaxSumBottomUp {

    private int m;
    private int n;
    private int[][] cache;


    private int bottomUp(int[][] path) {

        fill(path);
        int q = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            q = Math.max(q, cache[0][j]);
        }
        return q;
    }

    private void fill(int[][] path) {

        for (int j = 0; j < n; j++) {

            cache[m - 1][j] = path[m - 1][j];

        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int sum = path[i][j];
                int p = 0, q = 0;
                if (j + 1 < n) {
                    p = sum + cache[i + 1][j + 1];
                }
                if (j - 1 >= 0) {
                    q = sum + cache[i + 1][j - 1];
                }
                cache[i][j] = Math.max(Math.max(sum + cache[i + 1][j], p), q);
            }
        }

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] path = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    path[i][j] = scanner.nextInt();
                }
            }
            int[][] cache = new int[1000][1000];
            MaxSumBottomUp maxSum = new MaxSumBottomUp();
            maxSum.m = m;
            maxSum.n = n;
            maxSum.cache = cache;
            System.out.println(maxSum.bottomUp(path));
            t--;
        }
        scanner.close();
    }
}
