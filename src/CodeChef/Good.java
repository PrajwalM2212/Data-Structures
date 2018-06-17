package CodeChef;

import java.util.Scanner;

public class Good {

    private int solve(int[] a, int k, int m) {

        int s = 0;
        for (int i = m; i < a.length; i++) {
            if (a[i] == 0) {
                for (int j = 1; j <= a.length; j++) {
                    int q = 0;
                    for (int p = 0; p < a.length; p++) {
                        if (a[p] == j) {
                            q = 1;
                            break;
                        }
                    }
                    if (q == 1) {
                        continue;
                    }
                    a[i] = j;
                    s = s + solve(a, k, i);
                    int c = 0;
                    for (int r = 1; r < a.length; r++) {
                        if (a[r] > a[r - 1]) {
                            c++;
                        }
                    }
                    if (c == k) {
                        s = s+1;
                    }
                }
            }
        }

        return s;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            Good good = new Good();

            System.out.println(good.solve(a, k, 0));
            t--;
        }
    }
}
