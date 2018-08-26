package DPproblems;

public class ChangeRev {

    int[] coins;
    int target;


    private int solve(int sum) {

        if (sum > target) {
            return 1000;
        }


        if (sum == target) {
            return 0;
        }

        int min = 1000;

        for (int i = 0; i < coins.length; i++) {

            min = Math.min(min, 1 + solve(sum + coins[i]));


        }
        return min;
    }


    public static void main(String[] args) {

        ChangeRev changeRev = new ChangeRev();
        changeRev.coins = new int[]{2, 4, 3};
        changeRev.target = 10;
        System.out.println(changeRev.solve(0));

    }


}
