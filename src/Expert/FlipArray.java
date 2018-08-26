package Expert;

public class FlipArray {


    private int[] values;

    private int find(int sum, int n) {

        if (n == values.length) {

            if (sum < 0) {
                return 10000;
            }

            return sum;

        }

        int a = find(sum - values[n], n + 1);
        int b = find(sum + values[n], n + 1);


        return Math.min(a, b);

    }

    private int solve(int numFlips, int minSum, int sum, int n) {

        if (n != 0 && sum == minSum) {
            return numFlips;
        }

        if (n == values.length) {
            return 1000;
        }

        int a = solve(numFlips + 1, minSum, sum - values[n], n + 1);
        int b = solve(numFlips, minSum, sum + values[n], n + 1);


        return Math.min(a, b);

    }


    public static void main(String[] args) {

        FlipArray flipArray = new FlipArray();
        flipArray.values = new int[]{15, 10, 6};
        int minSum = flipArray.find(0, 0);
        System.out.println(flipArray.solve(0, minSum, 0, 0));

    }


}
