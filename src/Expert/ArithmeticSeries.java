package Expert;

import java.util.HashMap;

public class ArithmeticSeries {

    private int numRecur = 0;
    private HashMap<Integer, Integer>[] map = new HashMap[3];

    private int solve(int[] arr) {

        for (int i = 0; i < map.length; i++) {
            map[i] = new HashMap<>();
        }

        int num = 0;
        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                num += solveRecur(arr, i, arr[j] - arr[i], 1);

            }

        }

        return num;

    }

    private int solveRecur(int[] arr, int i, int diff, int count) {

        if (count > 2 && map[i].get(diff) != null) {
            return map[i].get(diff);
        }

        numRecur++;

        int times = 0;
        boolean isMove = false;
        for (int ind = i + 1; ind < arr.length; ind++) {

            if (arr[ind] - arr[i] == diff) {

                if (count > 2) {
                    times = 1 + solveRecur(arr, ind, diff, count + 1);
                    isMove = true;
                } else {
                    times += solveRecur(arr, ind, diff, count + 1);
                    isMove = true;
                }


            }

        }


        if (!isMove && count > 2) {
            System.out.println("I have reached " + arr[i] + " with a difference " + diff + " and contain " + count + " elements");
            map[i].put(diff, 1);
            return 1;
        }

        if (count > 2) {
            map[i].put(diff, times);
        }

        return times;

    }


    public static void main(String[] args) {
        ArithmeticSeries arithmeticSeries = new ArithmeticSeries();
        System.out.println(arithmeticSeries.solve(new int[]{0,2000000000,-294967296}));
        System.out.println("Number of recursive calls " + arithmeticSeries.numRecur);
    }
}
