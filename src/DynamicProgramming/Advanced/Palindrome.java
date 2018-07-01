package DynamicProgramming.Advanced;

import java.util.Scanner;

public class Palindrome {

    private String[][] matrix;
    private int n;
    private int m;
    private int c = 0;
    private int[][] cache;

    private int numPalindrome(String s, int i, int j) {

        String value = matrix[i][j];
        s = s + value;
        System.out.println(s);

        int count = 0;
        if (i == n && j == m) {
            if (new StringBuilder(s).reverse().toString().equals(s)) {
                c++;
                return 1;
            } else {
                return 0;
            }
        }


        if (i == n && j != m) {
            count += numPalindrome(s, i, j + 1);
        } else if (j == m && i != n) {
            count += numPalindrome(s, i + 1, j);
        } else {
            count += numPalindrome(s, i, j + 1);
            count += numPalindrome(s, i + 1, j);
        }

        return count;

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[][] matrix = new String[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.next();
            }
        }

        int[][] cache = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cache[i][j] = -1;
            }
        }
        Palindrome palindrome = new Palindrome();
        palindrome.matrix = matrix;
        palindrome.m = m - 1;
        palindrome.n = n - 1;
        palindrome.cache = cache;
        System.out.println(palindrome.numPalindrome("", 0, 0));
        System.out.println(palindrome.c);

    }
}
