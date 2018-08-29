package Expert;

public class ArithmeticSeries {

    private int numRecur = 0;

    private int solve(int[] arr) {

        int num = 0;
        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                num += solveRecur(arr, i, arr[j] - arr[i], 1);

            }

        }
        return num;

    }

    private int solveRecur(int[] arr, int i, int diff, int count) {

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
            System.out.println("I have reached " + arr[i] + " with a difference " + diff + " and contain " + count +" elements");
            return 1;
        }

        return times;

    }


    public static void main(String[] args) {
        ArithmeticSeries arithmeticSeries = new ArithmeticSeries();
        System.out.println(arithmeticSeries.solve(new int[]{2,3,6,4,8,9,10}));
        System.out.println("Number of recursive calls " + arithmeticSeries.numRecur);
    }
}
