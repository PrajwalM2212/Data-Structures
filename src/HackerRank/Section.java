package HackerRank;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.out;

public class Section {

    // Complete the whichSection function below.
    static int whichSection(int n, int k, int[] a) {
        // Return the section number you will be assigned to assuming you are student number k.

        int section = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
            if (k <= sum) {
                section = i + 1;
                break;
            }
        }

        return section;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nkm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nkm[0]);

            int k = Integer.parseInt(nkm[1]);

            int m = Integer.parseInt(nkm[2]);

            int[] a = new int[m];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < m; i++) {
                int aItem = Integer.parseInt(aItems[i]);
                a[i] = aItem;
            }

            int result = whichSection(n, k, a);
            out.println(result);

        }

        scanner.close();
    }
}
