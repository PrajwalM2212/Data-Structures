package DynamicProgramming;

import java.util.Scanner;

public class MaxSumTopDown {

    // example array of 6 rows and 5 columns
    /*      6 5
            3 1 7 4 2
            2 1 3 1 1
            1 2 2 1 8
            2 2 1 5 3
            2 1 4 4 4
            5 2 7 5 1 */


    // index of array
    private int m, n;
    //array to store values of sub problems
    private int[][] cache;
    // variable to calculate number of recursion calls
    private int count;

    // I loop through first row and call recur() to find the largest sum
    private int solve(int[][] path) {

        int q = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {

            q = Math.max(q, recur(path, 0, i));

        }
        return q;
    }

    // actual recursive function
    // rn = max{(path[row+1][col] + rn-1),(path[row+1][col+1] + rn-1),(path[row+1][col-1] + rn-1)} is the recursion relation
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
            // if it does exceed the number of columns
            q = recur(path, row + 1, col + 1);
        }
        if (col - 1 >= 0) {
            // if it does not exceed the number of rows
            r = recur(path, row + 1, col - 1);
        }

        int sum = path[row][col];

        if (cache[row][col] == 0) {
            //implementation of recursive formula
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
            MaxSumTopDown maxSum = new MaxSumTopDown();
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
