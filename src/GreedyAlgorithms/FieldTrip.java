package GreedyAlgorithms;

import java.util.Scanner;

import static java.lang.System.out;

public class FieldTrip {

    // provide the answer
    private int solve(String[] arr) {

        if (isEqual(arr)) {
            return 0;
        }

        arr[0] = shortPath(arr[0], farPath(arr));
        // out.println(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            arr[i] = shortPath(arr[i], arr[i - 1]);
            //out.println(arr[i]);
        }

        return 1 + solve(arr);

    }

    // check if all array elements are equal
    private boolean isEqual(String[] arr) {


        int k = 0;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i].equals(arr[0])) {
                k = 0;
            } else {
                k = 1;
            }

        }

        return k == 0;

    }

    private String farPath(String[] arr) {

        int a = Integer.valueOf(arr[0].split(",")[0]);
        int b = Integer.valueOf(arr[0].split(",")[1]);


        double max = Integer.MIN_VALUE;
        String ans = "";
        for (int i = 1; i < arr.length; i++) {
            int p = Integer.valueOf(arr[i].split(",")[0]);
            int q = Integer.valueOf(arr[i].split(",")[1]);
            double m = (Math.pow(p - a, 2) + Math.pow(q - b, 2));
            if (max == m) {
                ans = "";
                ans = ans.concat(String.valueOf(a) + "," + String.valueOf(b));
            } else {
                max = Math.max(max, m);
                if (max == m) {
                    ans = "";
                    ans = ans.concat(String.valueOf(p) + "," + String.valueOf(q));
                }
            }
        }

        return ans;

    }

    // minimize s wrt to ref
    private String shortPath(String s, String ref) {

        int a = Integer.valueOf(s.split(",")[0]);
        int b = Integer.valueOf(s.split(",")[1]);

        int p = Integer.valueOf(ref.split(",")[0]);
        int q = Integer.valueOf(ref.split(",")[1]);

        int[][] arr = new int[][]{{a, b}, {a + 1, b}, {a - 1, b},
                {a, b + 1}, {a, b - 1}, {a + 1, b + 1}, {a + 1, b - 1},
                {a - 1, b - 1}, {a - 1, b + 1}};

        double min = Integer.MAX_VALUE;
        String ans = "";
        for (int i = 0; i < 9; i++) {

            double m = (Math.pow(p - arr[i][0], 2) + Math.pow(q - arr[i][1], 2));
            min = Math.min(min, m);
            if (min == m) {
                ans = "";
                ans = ans.concat(String.valueOf(arr[i][0]) + "," + String.valueOf(arr[i][1]));
            }

        }

        return ans;

    }

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int k = 1;
        while (t > 0) {
            int n = scanner.nextInt();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                int m = scanner.nextInt();
                int q = scanner.nextInt();
                arr[i] = String.valueOf(m + "," + q);
            }
            FieldTrip trip = new FieldTrip();
            out.println("Case #" + k + ": " + trip.solve(arr));
            k++;
            t--;
        }

    }
}
