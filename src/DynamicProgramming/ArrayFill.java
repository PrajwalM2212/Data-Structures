package DynamicProgramming;

import java.util.HashMap;
import java.util.Scanner;

public class ArrayFill {

    private int n;
    private int k;
    private int x;
    private int[] a;
    private HashMap<Integer, Integer> map = new HashMap<>();
    private int[][] cache = new int[1000][1000];


    private int recur(int pos) {

        int count = 0;
        for (int i = 1; i <= k; i++) {
            if (a[pos - 1] == i) {
                continue;
            }
            if (pos == n - 2) {
                if (a[pos + 1] == i) {
                    continue;
                }
            }
            a[pos] = i;
            if (pos < n - 2) {
                count = count + recur(pos + 1);
            }
            if (pos == n - 2) {
                count++;
                for (int e : a) {
                    System.out.println(e);
                }
                System.out.println("\n");
            }
        }
        return count;
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
        System.out.println(fill.recur(1));

    }
}
