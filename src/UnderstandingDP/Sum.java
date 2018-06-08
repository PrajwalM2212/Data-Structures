package UnderstandingDP;

import java.util.Scanner;

public class Sum {

    private int[] a;
    private int key;
    private int count = 0;
    private int[][] cache = new int[1000][1000];

    private int recur(int sum, int k) {

        if (sum == key) {
            return 1;
        }

        if (sum > key) {
            return 0;
        }

        int c = 0;
        for (int i = k; i < a.length; i++) {
            if (cache[sum][a[i]] == 0) {
                cache[sum][a[i]] = recur(sum + a[i], k);
            }
            c = c + cache[sum][a[i]];
            k++;
        }
        return c;
    }

    public static void main(String[] args) {

        Sum sum = new Sum();
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        sum.a = a;
        sum.key = key;
        System.out.println(sum.recur(0, 0));
        System.out.println(sum.count);
    }
}
