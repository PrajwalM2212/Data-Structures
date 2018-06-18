package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class AngryChildren {


    private int[] packets;
    private int[][] cache;

    private int solve(int k) {

        // store elements at index 0
        cache[1][0] = packets[0];
        packets[0] = -1;
        // unfairness in element at index 1
        cache[1][1] = 0;
        for (int i = 2; i <= k; i++) {

            cache[i][1] = cache[i - 1][1] + calc(i);

        }

        return cache[k][1];
    }

    private int calc(int sz) {

        int min = Integer.MAX_VALUE;
        int w = -1;
        for (int i = 0; i < packets.length; i++) {

            if (packets[i] == -1) {
                continue;
            }
            int unfairness = 0;
            for (int j = 1; j < sz; j++) {
                unfairness = unfairness + Math.abs(cache[j][0] - packets[i]);
            }
            min = Math.min(min, unfairness);
            if (min == unfairness) {
                w = i;
            }

        }

        cache[sz][0] = packets[w];
        packets[w] = -1;
        return min;

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] packets = new int[n];
        for (int j = 0; j < n; j++) {
            packets[j] = scanner.nextInt();
        }
        AngryChildren children = new AngryChildren();
        Arrays.sort(packets);
        children.packets = packets;
        children.cache = new int[k + 1][2];
        System.out.println(children.solve(k));

    }
}
