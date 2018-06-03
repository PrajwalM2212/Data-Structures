package Backtracking;

import java.util.Scanner;

public class CoinSum {

    private int count = 0;

    private void backtrack(int key, int sum, int k, int[] candidates) {

        for (int i = k; i < candidates.length; i++) {
            sum = sum + candidates[i];
            if (sum < key) {
                if (i == 0) {
                    backtrack(key, sum, 0, candidates);
                } else {
                    backtrack(key, sum, i, candidates);
                }
            }
            if (sum == key) {
                count++;
            }
            sum = sum - candidates[i];
        }

    }

    public static void main(String[] args) {
        CoinSum cs = new CoinSum();
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        cs.backtrack(key, 0, 0, a);
        System.out.print(cs.count);
    }
}
