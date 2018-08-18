package Expert;

import java.util.HashMap;

public class CoinGame {

    // using map to store the value and make it a DP problem
    private HashMap<String, Integer> map = new HashMap<>();
    private int numIter = 0;

    private int coin(String coinString, int count) {

        if (map.get(coinString) != null) {
            return map.get(coinString);
        }

        numIter++;
        int a = 0, b = 0;
        // if count is not even(my move)
        if (count % 2 != 0 && coinString.length() > 0) {

            // i don't know if taking out the right or left most will increase my sum and hence i will try both and see and then take the max of those


            a = Integer.valueOf(String.valueOf(coinString.charAt(0))) + coin(coinString.substring(1), count + 1);

            b = Integer.valueOf(String.valueOf(coinString.charAt(coinString.length() - 1))) + coin(coinString.substring(0, coinString.length() - 1), count + 1);


        }

        if (count % 2 == 0 && coinString.length() > 0) {
            // if count is even (opponents move)
            // the opponent tries to reduce my sum and hence always takes out the largest number

            if (Integer.valueOf(String.valueOf(coinString.charAt(0))) > Integer.valueOf(String.valueOf(coinString.charAt(coinString.length() - 1)))) {

                a = coin(coinString.substring(1), count + 1);

            } else {

                b = coin(coinString.substring(0, coinString.length() - 1), count + 1);

            }

        }

        map.put(coinString, Math.max(a, b));
        return map.get(coinString);

    }


    public static void main(String[] args) {


        CoinGame game = new CoinGame();
        System.out.println(game.coin("123442431657", 1));
        System.out.println(game.numIter);


    }


}
