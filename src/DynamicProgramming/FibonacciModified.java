package DynamicProgramming;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class FibonacciModified {

    private BigInteger t1;
    private BigInteger t2;

    HashMap<Integer, BigInteger> hashMap = new HashMap<>();

    private BigInteger recur(int i) {
        if (hashMap.get(i) != null) {
            return hashMap.get(i);
        }
        if (i == 0) {
            return t1;
        }
        if (i == 1) {
            return t2;
        }
        hashMap.put(i - 1, recur(i - 1));
        hashMap.put(i - 2, recur(i - 2));
        return (hashMap.get(i - 1).multiply(hashMap.get(i - 1))).add(hashMap.get(i - 2));
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FibonacciModified fib = new FibonacciModified();
        fib.t1 = scanner.nextBigInteger();
        fib.t2 = scanner.nextBigInteger();
        System.out.println(fib.recur(scanner.nextInt() - 1));

    }
}
