package Recursion;

import java.util.Scanner;

public class Pi {

    private void recur(String s) {
        System.out.println(pi(s, 0));
    }

    private String pi(String s, int k) {
        if (k == s.length() - 1) {
            return s;
        }
        if (s.charAt(k) == 'p' && s.charAt(k + 1) == 'i') {
            s = s.replace("pi", "3.14");
        }
        return pi(s, k + 1);

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        Pi pi = new Pi();
        while (t > 0) {
            pi.recur(scanner.next());
            t--;
        }
        scanner.close();
    }
}
