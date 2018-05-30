package Recursion.advanced_problems;

import java.util.Scanner;

public class KFactorization {

    private void factRec(int[] a, int length, int key, int feed, String exp) {

        for (int i = 0; i < length; i++) {
            int newFeed = feed * a[i];
            String expression = exp + " " + a[i];
            if (newFeed > key) {
                break;
            }
            if (newFeed == key) {
                System.out.println(feed + " " + a[i]);
                System.out.println(expression);
                System.out.println("\n");
            }
            factRec(a, length, key, newFeed, expression);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        scanner.close();
        KFactorization kF = new KFactorization();
        kF.factRec(a, a.length, key, 1, "1");

    }
}
