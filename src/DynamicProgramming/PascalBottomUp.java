package DynamicProgramming;

import java.util.Scanner;

public class PascalBottomUp {

    private void solve(int[][] matrix, int m) {
        for (int i = 0; i < m; i++) {
            matrix[i][0] = 1;
            matrix[i][i] = 1;
            for (int j = 1; j < i; j++) {
                matrix[i][j] = matrix[i - 1][j - 1] + matrix[i - 1][j];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        scanner.close();
        int[][] matrix = new int[m][m];
        PascalBottomUp pascal = new PascalBottomUp();
        pascal.solve(matrix, m);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    System.out.print("");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println("\n");
        }
    }

}

