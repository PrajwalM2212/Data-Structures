package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;


public class SubArray {

    private long[] a;
    private long n;
    private long maxi = Integer.MIN_VALUE;
    private long maxS = 0;
    private long[][] memo;

    private void solve() {

        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                memo[i][i] = a[i];
            } else {
                memo[i][i] = memo[i - 1][i] - a[i - 1];
            }
            if (memo[i][i] > maxi) {
                maxi = memo[i][i];
            }
            for (int j = i + 1; j < a.length; j++) {
                if (i == 0) {
                    memo[i][j] = memo[i][j - 1] + a[j];
                } else {
                    memo[i][j] = memo[i - 1][j] - a[i - 1];
                }
                if (memo[i][j] > maxi) {
                    maxi = memo[i][j];
                }
            }
        }


        Arrays.sort(a);
        if (a[a.length - 1] < 0) {
            for (int i = 0; i < a.length / 2; i++) {
                long temp = a[i];
                a[i] = a[a.length - i - 1];
                a[a.length - i - 1] = temp;
            }
            maxS = a[0];
        } else {
            for (int i = a.length - 1; i >= 0; i--) {

                if (a[i] > 0) {
                    maxS = maxS + a[i];
                } else {
                    break;
                }

            }
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {
            int n = scanner.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            long[][] memo = new long[n][n];
            SubArray subArray = new SubArray();
            subArray.a = a;
            subArray.n = n;
            subArray.memo = memo;
            subArray.solve();
            System.out.println(subArray.maxi + " " + subArray.maxS);
            t--;
        }
        scanner.close();

    }
}
