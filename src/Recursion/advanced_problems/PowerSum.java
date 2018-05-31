package Recursion.advanced_problems;

import java.util.Scanner;

public class PowerSum {


    private int count = 0;

    private void powerSum(int[] arr, int start, int feed, int n, String eps) {

        for (int i = start; i < arr.length; i++) {
            if (feed > n) {
                break;
            }
            int sum = feed + arr[i];
            String exp = eps + " " + arr[i];
            if (sum == n) {
                count++;
                //  System.out.println(exp);
            }
            powerSum(arr, i + 1, sum, n, exp);
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int pow = scanner.nextInt();
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (Math.pow(i, pow) <= n) {
                count++;
            } else {
                break;
            }
        }
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = (int) Math.pow(i + 1, pow);
        }
       /* for (int e : arr) {
            System.out.println(e);
        }*/
        PowerSum pS = new PowerSum();
        pS.powerSum(arr, 0, 0, n, "0");
        System.out.println(pS.count);
    }
}
