package DynamicProgramming;

import java.util.Scanner;

public class KCoins {

    private int[][] arr = new int[1000][1000];

    private int count = 0;

    private void kCoins(int[] a, int sum, int feed, int index) {

        for (int i = index; i < a.length; i++) {
            int newFeed = feed + a[i];
            if (feed > sum) {
                break;
            }
            if (newFeed == sum) {
                count++;
            }
            kCoins(a, sum, newFeed, i);
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int numCoins = scanner.nextInt();
        int[] coins = new int[numCoins];
        for (int i = 0; i < numCoins; i++) {
            coins[i] = scanner.nextInt();
        }

        KCoins kC = new KCoins();
        kC.kCoins(coins, sum, 0, 0);
        System.out.println(kC.count);
        scanner.close();

    }
}
