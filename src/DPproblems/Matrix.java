package DPproblems;

import static java.lang.System.out;

public class Matrix {

    private int m;
    private int n;
    private int[][] matrix;

    // top down dp
    private int solve(int i, int j, int[][] cache) {

        if (cache[i][j] != 0) {
            return cache[i][j];
        }

        // terminating condition
        if (i == m - 1 && j == n - 1) {
            return 0;
        }

        // boundary condition
        if (i == m - 1) {
            return cache[i][j] = matrix[i][j] + solve(i, j + 1, cache);
        }

        // boundary condition
        if (j == n - 1) {
            return cache[i][j] = matrix[i][j] + solve(i + 1, j, cache);
        }

        return cache[i][j] = Math.min(matrix[i][j] + solve(i + 1, j, cache), matrix[i][j] + solve(i, j + 1, cache));


    }


    public static void main(String[] args) {

        Matrix matrix = new Matrix();
        matrix.m = 4;
        matrix.n = 3;
        matrix.matrix = new int[][]{

                {2, 3, 6},
                {3, 4, 5},
                {3, 4, 5},
                {8, 6, 5}
        };

        out.println(matrix.solve(0, 0, new int[4][3]));


    }


}
