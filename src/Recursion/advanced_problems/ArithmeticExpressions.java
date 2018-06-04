package Recursion.advanced_problems;

import java.util.Scanner;

public class ArithmeticExpressions {


    private int[] a;

    private void isSolvable(int feed, int count, String expression) {

       /* if (count > a.length - 1) {
            return false;
        }*/


        String lE = expression + "+" + String.valueOf(a[count]);
        String mE = expression + "-" + String.valueOf(a[count]);
        String nE = expression + "*" + String.valueOf(a[count]);
        //String oE = expression + "/" + String.valueOf(a[count]);

        int l = feed + a[count];
        int m = feed - a[count];
        int n = feed * a[count];
        //int o = feed / a[count];

        if (count == a.length - 1) {

            if (l % 101 == 0) {
                System.out.println(lE);
                System.out.println(l);
                System.exit(1);
            }
            if (m % 101 == 0) {
                System.out.println(mE);
                System.out.println(m);
                System.exit(1);
            }
            if (n % 101 == 0) {
                System.out.println(nE);
                System.out.println(n);
                System.exit(1);
            }

           /* if ((l % 101 == 0 || m % 101 == 0 || n % 101 == 0 || o % 101 == 0)) {
                System.out.println(lE);
                System.out.println(mE);
                System.out.println(nE);
                // System.out.println(oE);
                //return true;
            }*/
        }

        if (count < a.length - 1) {
            isSolvable(l, count + 1, lE);
            isSolvable(m, count + 1, mE);
            isSolvable(n, count + 1, nE);
        }/*|| isSolvable(o, a, count + 1, oE)*/
        ;

    }

    public static void main(String[] args) {

        ArithmeticExpressions ae = new ArithmeticExpressions();
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] a = new int[num];
        for (int i = 0; i < num; i++) {
            a[i] = scanner.nextInt();
        }
        ae.a = a;
        ae.isSolvable(a[0], 1, String.valueOf(a[0]));
        scanner.close();

    }


}
