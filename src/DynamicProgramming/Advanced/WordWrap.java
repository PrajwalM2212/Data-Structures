package DynamicProgramming.Advanced;

import java.util.Scanner;

public class WordWrap {

    private int findMin(int start, int max, int[] arr) {

        int curMax = max;
        int sum = 0;
        int error = Integer.MAX_VALUE;
        int ind = start;
        while (curMax >= arr[start]) {
            sum = sum + arr[start];
            if (start < arr.length - 1) {
                start++;
                error = Math.min(error, (int) Math.pow((max - sum), 3) + findMin(start, max, arr));
            } else {
                error = (int) Math.pow((max - sum), 3);
            }
            curMax = curMax - (sum);
        }

       // System.out.println(ind + " " + error);
        return error;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int max = scanner.nextInt();
        WordWrap wordWrap = new WordWrap();
        System.out.println(wordWrap.findMin(0, max, arr));
    }
}
