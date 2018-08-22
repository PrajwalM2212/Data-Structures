package Expert;

import static java.lang.System.out;

public class Dungeon {

    int[][] matrix;
    int m;
    int n;

    // top-down dp
    private int solve(int health, int i, int j, int[][] cache) {

        if (cache[i][j] != 0) {
            return cache[i][j];
        }


        out.println(health + " " + i + " " + j);

        // terminating condition
        if (i == m - 1 && j == 0) {

            if (matrix[i][j] > health) {
                return cache[i][j] = 1;
            } else {
                return cache[i][j] = health - matrix[i][j];
            }

        }

        // boundary condition
        if (j == 0) {

            if (matrix[i][j] > health) {
                return cache[i][j] = solve(1, i + 1, j, cache);
            } else {
                return cache[i][j] = solve(health - matrix[i][j], i + 1, j, cache);
            }

        }

        // boundary condition
        if (i == m - 1) {

            if (matrix[i][j] > health) {
                return cache[i][j] = solve(1, i, j - 1, cache);
            } else {
                return cache[i][j] = solve(health - matrix[i][j], i, j - 1, cache);
            }

        }


        if (matrix[i][j] > health) {

            return cache[i][j] = Math.min(solve(1, i + 1, j, cache), 1 + solve(1, i, j - 1, cache));

        } else {

            return cache[i][j] = Math.min(solve(health - matrix[i][j], i + 1, j, cache), solve(health - matrix[i][j], i, j - 1, cache));

        }


    }

    public static void main(String[] args) {

        Dungeon dungeon = new Dungeon();
        dungeon.m = 3;
        dungeon.n = 3;
        dungeon.matrix = new int[][]{

                {10, 30, -5},
                {-5, -10, 1},
                {-2, -3, 3},

        };

        out.println(dungeon.solve(1, 0, 2, new int[3][3]));


    }


}
