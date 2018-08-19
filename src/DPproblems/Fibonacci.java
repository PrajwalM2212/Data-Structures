package DPproblems;

import java.util.Arrays;

public class Fibonacci {

    /*
    I will call Fibonacci as a type - 1 DP problem.
     */


    // bottom-up solution
    private int fib(int n) {

        int[] fib = new int[n];

        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }


        return fib[n - 1];
    }

    // top-down solution
    private int fib2(int n) {

        int[] fib = new int[n+2];
        Arrays.fill(fib,-1);

        fib[1] = 0;
        fib[2] = 1;

        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }


        return cal(n, fib);


    }

    private int cal(int n, int[] fib) {

        if (fib[n] != -1) {
            return fib[n];
        }

        fib[n] = cal(n - 1, fib) + cal(n - 2, fib);
        return fib[n];

    }


    public static void main(String[] args) {
        System.out.println(new Fibonacci().fib(12));
        System.out.println(new Fibonacci().fib2(12));
    }


}
