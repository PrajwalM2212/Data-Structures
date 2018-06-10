package DynamicProgramming;

import java.util.HashMap;
import java.util.Scanner;

public class SummingPieces {


    private long recur(int[] b) {

        long sum = 0;
        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 1; i <= b.length; i++) {

            sum = sum + dynamic(b, i, map, 0);

        }
        return sum;
    }

    private long dynamic(int[] b, int i, HashMap<Long, Long> map, int k) {

        int sum = 0;


        return sum + dynamic(b, i, map, k + 1);

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        SummingPieces pieces = new SummingPieces();
        System.out.print(pieces.recur(b));
    }
}
