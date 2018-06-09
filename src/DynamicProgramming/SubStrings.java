package DynamicProgramming;


import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class SubStrings {


    private BigInteger recur(String s, int k) {

        if (s.length() < k) {
            return new BigInteger("0");
        }

        return (new BigInteger(s.substring(0, k)).add(recur(s.substring(1), k)));

    }


    private BigInteger dynamic(String s) {
        BigInteger sum = new BigInteger("0");
        for (int i = 1; i <= s.length(); i++) {
            sum = sum.add(recur(s, i));
        }
        BigInteger mod = new BigInteger("1000000007");
        return sum.mod(mod);
    }


    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        SubStrings subStrings = new SubStrings();
        System.out.println(subStrings.dynamic(n));
        scanner.close();

    }
}
