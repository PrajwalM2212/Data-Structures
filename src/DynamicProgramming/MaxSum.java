package DynamicProgramming;

import java.util.Scanner;

public class MaxSum {

    private int m, n;
    private int[][] cache;
    private int count;

    private int solve(int[][] path) {

        int q = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {

            q = Math.max(q, recur(path, 0, i));

        }
        return q;
    }

    private int recur(int[][] path, int row, int col) {

        if (cache[row][col] != 0) {
            return cache[row][col];
        }

        count++;
        if (row == m - 1) {
            return path[row][col];
        }

        int p = recur(path, row + 1, col);
        int q = 0, r = 0;
        if (col + 1 <= n - 1) {
            q = recur(path, row + 1, col + 1);
        }
        if (col - 1 >= 0) {
            r = recur(path, row + 1, col - 1);
        }

        int sum = path[row][col];

        if (cache[row][col] == 0) {
            cache[row][col] = Math.max(Math.max(sum + p, sum + q), sum + r);
        }
        return cache[row][col];

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
            MaxSum maxSum = new MaxSum();
            maxSum.m = m;
            maxSum.n = n;
            maxSum.cache = cache;
            System.out.println(maxSum.solve(path));
            System.out.println(maxSum.count);
            t--;
        }
        scanner.close();
    }
}
