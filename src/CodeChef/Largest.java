package CodeChef;

import java.math.BigInteger;
import java.util.Scanner;

public class Largest {


    private void solve(BigInteger a, BigInteger b, long n) {

        if (n % 2 == 0) {
            if (a.compareTo(new BigInteger("0")) < 0) {
                a = a.multiply(new BigInteger("-1"));
            }

            if (b.compareTo(new BigInteger("0")) < 0) {
                b = b.multiply(new BigInteger("-1"));
            }

            if (a.compareTo(b) > 0) {
                System.out.println(1);
            } else if (a.compareTo(b) < 0) {
                System.out.println(2);
            } else {
                System.out.println(0);
            }
            
        } else {

            if (a.compareTo(b) > 0) {
                System.out.println(1);
            } else if (a.compareTo(b) < 0) {
                System.out.println(2);
            } else {
                System.out.println(0);
            }

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Largest largest = new Largest();
        int t = scanner.nextInt();
        while (t > 0) {
            BigInteger a = scanner.nextBigInteger();
            BigInteger b = scanner.nextBigInteger();
            Long n = scanner.nextLong();
            largest.solve(a, b, n);
            t--;
        }
    }
}
