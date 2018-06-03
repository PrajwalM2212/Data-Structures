package Backtracking;

import java.util.Scanner;

import static sun.tools.java.Constants.FALSE;
import static sun.tools.java.Constants.TRUE;

public class Subset {

    private int numCan = 2;
    private int[] c = new int[numCan];

    /*
    the functions needed are is_solution , process_solution , compute_candidates, make_move, unmake_move
    */

    /**
     * @param a the solution array/vector. Solution can be generated from this array
     * @param k the currently filled spot in array a
     * @param n size of a
     */
    /*
    To check if first k elements form a complete solution where n is the size of the target solution
     */
    private boolean isSolution(int[] a, int k, int n) {
        return k == n;
    }

    /*
    Processes the solution by printing , counting etc
     */
    private void processSolution(int[] a, int k, int n) {
        System.out.print("{ ");
        for (int i = 1; i <= k; i++) {
            if (a[i] == TRUE) {
                System.out.print(i + " ");
            }
        }
        System.out.print("}");
    }

    /*
    Make a move
     */
    private void makeMove(int[] a, int k, int n) {

    }

    /*
    Unmake a move while backtracking
     */
    private void unmakeMove(int[] a, int k, int n) {

    }

    /*
    Fills the array c with the complete set of possible candidates for the kth position of a given
    the contents of k-1 positions
     */
    private void constructCandidates(int[] a, int[] c, int numCandidates) {
        c[0] = TRUE;
        c[1] = FALSE;
    }

    private void backtrack(int[] a, int k, int n) {
        // checks and processes
        if (isSolution(a, k, n)) {
            processSolution(a, k, n);
        } else {
            // increments k
            k = k + 1;
            constructCandidates(a, c, numCan);
            for (int i = 0; i < numCan; i++) {
                a[k] = c[i];
                makeMove(a, k, n);
                backtrack(a, k, n);
                unmakeMove(a, k, n);
            }
        }
    }

    public static void main(String[] args) {
        Subset sb = new Subset();
        sb.backtrack(new int[4], 0, 3);
    }

}
