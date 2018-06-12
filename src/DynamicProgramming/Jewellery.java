package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Jewellery {

    //sorted array to make calculations easier
    private int[] values;//= new int[]{1, 2, 3, 4, 5};


    private int solve() {

        int sum = 0;

        for (int i = 0; i < values.length; i++) {
            sum = sum + recur(i, values, values[i]);
        }

        return sum;

    }

    private int recur(int k, int[] arr, int sum) {
        int count = dynamic(k, sum, arr, 0);
        int limit = sum(values, 0);
        for (int i = k + 1; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum > limit) {
                break;
            }
            count = count + recur(i, arr, sum);
        }

        return count;
    }

    // counting phase
    private int dynamic(int k, int key, int[] values, int sum) {

        int count = 0;
        int p = sum;
        for (int i = k + 1; i < values.length; i++) {
            p = p + values[i];
            if (p == key) {
                count++;
            }
            count = count + dynamic(i, key, values, p);
        }
        return count;
    }

    private int sum(int[] values, int k) {
        if (k == values.length - 1) {
            return values[values.length - 1];
        }
        return values[k] + sum(values, k + 1);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        Jewellery jewellery = new Jewellery();
        jewellery.values = arr;
        System.out.println(jewellery.solve());
    }

}
