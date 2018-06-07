package Backtracking;

import java.util.Scanner;

public class CoinSum {

    private int key;
    private int[] candidates;
    private long[][] cache = new long[10000][10000];
    private int recur = 0;

    private long backtrack(int sum, int k) {

        if (cache[sum][k] != 0) {
            return cache[sum][k];
        }

        recur++;
        long count = 0;

        for (int i = k; i < candidates.length; i++) {
            sum = sum + candidates[i];
            if (sum < key) {
                if (i == 0) {
                    count = count + backtrack(sum, 0);
                } else {
                    count = count + backtrack(sum, i);
                }
            }
            if (sum == key) {
                count++;
            }
            sum = sum - candidates[i];
        }

        return cache[sum][k] = count;

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
        cs.candidates = a;
        cs.key = key;
        System.out.print(cs.backtrack(0, 0));
        System.out.print("\n");
        System.out.print(cs.recur);
    }
}
