package DynamicProgramming;

import java.util.Scanner;

public class StockMaximize {

    int[] cache;

    private long solve(int start, long spent, int[] price, int shareCount) {


        if (start == price.length - 1) {
            return Math.max(0, Math.max(0, ((shareCount * price[start]) - spent)));
        }

        long profit = 0;
        //buy
        long buy = profit + solve(start + 1, spent + (price[start]), price, shareCount + 1);

        //do nothing
        long none = profit + solve(start + 1, spent, price, shareCount);

        //sold
        long sell = Integer.MIN_VALUE;
        if (start > 0) {
            sell = profit + ((shareCount * price[start]) - spent) + solve(start + 1, 0, price, 0);
        }

        return Math.max(Math.max(buy, none), sell);

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {
            int n = scanner.nextInt();
            int[] prices = new int[n];
            for (int i = 0; i < n; i++) {
                prices[i] = scanner.nextInt();
            }
            int[] cache = new int[n+1];
            StockMaximize maximize = new StockMaximize();
            maximize.cache=cache;
            System.out.println(maximize.solve(0, 0, prices, 0));
            t--;
        }
    }
}
