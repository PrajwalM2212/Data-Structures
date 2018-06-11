package Practice;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long digit;
        long reverse = 0;
        while (n > 0) {
            digit = n % 10;
            reverse = (reverse * 10) + digit;
            n = n / 10;
        }
        System.out.print(reverse);
    }
}
