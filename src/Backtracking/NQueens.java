package Backtracking;

import java.util.Scanner;

/**
 * is_solution
 * construct_candidates
 * process_solution
 * make_move
 * unmake_move
 */
public class NQueens {


    private boolean isSafe(int[][] board, int i, int j, int n) {
        return true;

    }

    private boolean nQueens(int[][] board, int n, int i) {

        if (i == n) {
            return true;
        }

        for (int j = 0; j < n; j++) {
            if (isSafe(board, i, j, n)) {
                board[i][j] = 1;
                boolean isNextQueen = nQueens(board, n, i + 1);
                if (isNextQueen) {
                    return true;
                }
                board[i][j] = 0;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] board = new int[n][n];


    }
}
