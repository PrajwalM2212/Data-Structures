package DynamicProgramming;

import java.util.Scanner;

public class ArrayFill {

    private int n;
    private int k;
    private int x;
    private int[] a;
    private int c;
    private int[][] cache = new int[100000][10000];

    private int backtrack(int size, int start) {

        if (cache[size][start] != 0) {
            return cache[size][start];
        }
        c++;
        int count = 0;

        for (int i = start; i <= size; i++) {
            for (int j = 1; j <= k; j++) {
                if (j == a[i - 1]) {
                    continue;
                }
                if (i == n - 2 && j == x) {
                    continue;
                }
                a[i] = j;
                if (i == n - 2) {
                    count++;
                    for (int e : a) {
                        System.out.println(e);
                    }
                    System.out.println("\n");
                }
                count = count + backtrack(size - i, start + i);
            }
        }
        return cache[size][start] = count;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int x = scanner.nextInt();
        int[] a = new int[n];
        a[0] = 1;
        a[n - 1] = x;
        ArrayFill fill = new ArrayFill();
        fill.n = n;
        fill.k = k;
        fill.x = x;
        fill.a = a;
        System.out.println(fill.backtrack(n - 1, 1));
        System.out.println(fill.c);

    }
}
