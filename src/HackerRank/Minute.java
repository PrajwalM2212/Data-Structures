package HackerRank;

import java.util.Scanner;

public class Minute {


    private int[] cache;

    // Complete the minuteToWinIt function below.
    private int minuteToWinIt(int[] a, int k, int start) {
        if(cache[start]!=0){
            return cache[start];
        }
        // Return the minimum amount of time in minutes.
        int c1 = 0;
        int c2 = 0;
        for (int i = start; i < a.length; i++) {

            if (a[i] - a[i - 1] != k) {

                int[] b = a;
                b[i] = -b[i];
                if (b[i] - b[i - 1] == k) {
                    c1 = c1 + 1;
                    c1 = c1 + minuteToWinIt(b, k, i + 1);
                }

                int[] c = a;
                c[i] = c[i - 1] + k;
                c2 = c2 + 1;
                c2 = c2 + minuteToWinIt(c, k, i + 1);

            }
        }



        if (c2 == 0) {
            return cache[start] = c1;
        } else if (c1 == 0) {
            return cache[start] = c2;
        } else {
            return cache[start] = Math.min(c1, c2);
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();

        int k = scanner.nextInt();

        int[] a = new int[n];


        for (int i = 0; i < n; i++) {
            int aItem = scanner.nextInt();
            a[i] = aItem;
        }

        int[] cache = new int[n+1];
        Minute minute = new Minute();
        minute.cache=cache;
        int result = minute.minuteToWinIt(a, k, 1);
        System.out.println(result);

        scanner.close();
    }


}
