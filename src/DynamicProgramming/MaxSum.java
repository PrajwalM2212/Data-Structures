package DynamicProgramming;

import java.util.Scanner;

public class MaxSum {

    private int m, n;
    private int[][][] cache = new int[100][100][100];
    private int count = 0;

    private int solve(int[][] path) {

        int q = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {

            q = Math.max(q, recur(path, path[0][i], 0, i));

        }

        return q;
    }

    private int recur(int[][] path, int sum, int row, int col) {

       /* int a = sum + path[row + 1][col];
        int b = sum + path[row + 1][col + 1];
        int c = sum + path[row + 1][col - 1];*/

        if (cache[sum][row][col] != 0) {
            return cache[sum][row][col];
        }
        count++;
        if (row < m - 1) {
            int p = recur(path, sum + path[row + 1][col], row + 1, col);
            int q = 0, r = 0;
            if (col + 1 <= n - 1) {
                q = recur(path, sum + path[row + 1][col + 1], row + 1, col + 1);
            }
            if (col - 1 >= 0) {
                r = recur(path, sum + path[row + 1][col - 1], row + 1, col - 1);
            }

            return cache[sum][row][col] = Math.max(Math.max(p, q), r);

        }

        return cache[sum][row][col] = Math.max(Integer.MIN_VALUE, sum);

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
            MaxSum maxSum = new MaxSum();
            maxSum.m = m;
            maxSum.n = n;
            System.out.println(maxSum.solve(path));
            System.out.println(maxSum.count);
            t--;
        }
        scanner.close();
    }
}
