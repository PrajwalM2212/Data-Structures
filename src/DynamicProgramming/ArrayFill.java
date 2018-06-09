package DynamicProgramming;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayFill {

    private int n;
    private int k;
    private int[] a;
    private BigInteger[][] cache;


    private BigInteger recur(int pos) {

        BigInteger count = new BigInteger("0");
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
                if (cache[pos][i].equals(BigInteger.valueOf(0))) {
                    BigInteger mod = new BigInteger("1000000007");
                    count = count.add(recur(pos + 1)).mod(mod);
                    cache[pos][i] = count;
                } else {
                    count = cache[pos][i];
                }
            }
            if (pos == n - 2) {
                count = count.add(new BigInteger("1"));
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
        fill.a = a;
        BigInteger[][] cache = new BigInteger[1000][1000];
        for (BigInteger[] row : cache) {
            Arrays.fill(row, BigInteger.ZERO);
        }
        fill.cache = cache;
        System.out.println((fill.recur(1)));
    }
}
