package Expert;

public class UniquePaths {

    int[][] matrix;
    int m;
    int n;


    private int solve(int i, int j, int[][] cache) {

        if (cache[i][j] != 0) {
            return cache[i][j];
        }

        System.out.println(i + " " + j);


        if (i == m - 1 && j == n - 1) {

            return cache[i][j] = 1;

        }

        if (i == m - 1 && matrix[i][j + 1] != 1) {

            return cache[i][j] = solve(i, j + 1, cache);

        }

        if (i == m - 1 && matrix[i][j + 1] == 1) {
            return cache[i][j] = 0;
        }


        if (j == n - 1 && matrix[i + 1][j] != 1) {

            return cache[i][j] = solve(i + 1, j, cache);

        }

        if (j == n - 1 && matrix[i + 1][j] == 1) {
            return cache[i][j] = 0;
        }


        int a = 0, b = 0;

        if (matrix[i + 1][j] != 1) {
            a = solve(i + 1, j, cache);
        }

        if (matrix[i][j + 1] != 1) {
            b = solve(i, j + 1, cache);
        }


        return cache[i][j] = a + b;


    }


    public static void main(String[] args) {
        UniquePaths paths = new UniquePaths();
        paths.m = 3;
        paths.n = 3;
        paths.matrix = new int[][]{

                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        System.out.println(paths.solve(0, 0, new int[3][3]));
    }


}
