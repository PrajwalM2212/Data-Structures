package DynamicProgramming;

import java.util.Scanner;

public class Cost {


    private int[] b;
    private int[] a;


    private int recur(int k, int max) {

        int m = max;
        for (int i = 1; i <= b[k]; i++) {
            a[k] = i;
            if (k < b.length - 1) {
                m = recur(k + 1, m);
            }
            if (k == b.length - 1) {
               /* for (int e : a) {
                    System.out.println(e);
                }*/
                int maxSum = 0;
                for (int j = a.length - 1; j > 0; j--) {
                    maxSum = maxSum + Math.abs(a[j] - a[j - 1]);
                }
                if (maxSum > m) {
                    m = maxSum;
                }
                // System.out.println(maxSum);
                // System.out.println("\n");
            }
            // backtrack
            a[k] = 0;
        }

        return m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        scanner.close();
        Cost cost = new Cost();
        cost.a = new int[n];
        cost.b = b;
        System.out.println(cost.recur(0, Integer.MIN_VALUE));
    }
}
