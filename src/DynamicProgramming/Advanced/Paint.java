package DynamicProgramming.Advanced;

import java.util.Scanner;

import static java.lang.System.out;

public class Paint {

    private int sum(int from, int to, int[] arr) {
        int sum = 0;
        for (int i = from; i <= to; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    private int solve(int k, int[] arr) {


        int[][] cache = new int[sum(0, arr.length - 1, arr)+1][k + 1];
        for (int j = 0; j < arr.length; j++) {
            for (int i = j; i < arr.length; i++) {
                cache[sum(j, i, arr)][2] = Math.max(sum(j, i, arr), sum(i + 1, arr.length - 1, arr));
            }
        }

        for (int p = 3; p <= k; p++) {
            for (int j = 0; j < arr.length; j++) {
                for (int i = j; i < arr.length; i++) {
                    cache[sum(j, i, arr)][p] = Math.max(sum(j, i, arr), cache[sum(i + 1, arr.length - 1, arr)][p - 1]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < arr.length; j++) {

            System.out.println(cache[sum(0, j, arr)][k]);
            min = Math.min(min, cache[sum(0, j, arr)][k]);

        }

        return min;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        Paint paint = new Paint();
        out.println(paint.solve(k, arr));

    }
}
