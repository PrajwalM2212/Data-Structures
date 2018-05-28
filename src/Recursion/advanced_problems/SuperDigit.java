package Recursion.advanced_problems;

import java.util.Scanner;

public class SuperDigit {

    private int superDigit(String sum) {
        if (numDigits(sum) == 1) {
            return Integer.valueOf(sum);
        }

        return superDigit(splitAndAdd(sum));

    }

    private String splitAndAdd(String s) {
        int length = s.length();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum = sum + Integer.valueOf(String.valueOf(s.charAt(i)));
        }

        return String.valueOf(sum);

    }

    private int numDigits(String sum) {
        return sum.length();
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String num = scanner.next();
        int factor = scanner.nextInt();

        int length = num.length();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum = sum + Integer.valueOf(String.valueOf(num.charAt(i)));
        }
        sum = sum*(factor);
        System.out.println(sum);
        SuperDigit solution = new SuperDigit();
        System.out.println(solution.superDigit(String.valueOf(sum)));

        scanner.close();

    }
}
