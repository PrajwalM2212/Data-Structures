package Recursion.advanced_problems;

import java.util.Arrays;
import java.util.Scanner;

public class KSums {

    private void kSum(int[] arr, int k, int[] tank) {


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int m = arr[arr.length - 1];
        int[] tank = new int[m];
        for (int i = 1; i < m; i++) {
            tank[i] = i;
        }

    }
}
