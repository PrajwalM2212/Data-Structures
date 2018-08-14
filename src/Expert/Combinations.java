package Expert;

import java.util.Scanner;

public class Combinations {


    private void genCombinations(String str, int k) {

        for (int i = 0; i < str.length(); i++) {

            /*
            Take a string in ascending order and split it into two parts . Pass the two parts into the recursive function
            123 => 1 and 23 , 2 and 3
             */
            recur(String.valueOf(str.charAt(i)), str.substring(i + 1), k);

        }

    }

    private void recur(String start, String remaining, int k) {

        if (start.length() < k) {

            for (int i = 0; i < remaining.length(); i++) {
                /*
                Take the remaining string split it into two parts . Append one part with the start. Pass the two parts into the recursive function
                 */
                recur(start + String.valueOf(remaining.charAt(i)), remaining.substring(i + 1), k);

            }


        } else if (start.length() == k) {

            System.out.println(start);

        }

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int k = scanner.nextInt();
        Combinations combinations = new Combinations();
        combinations.genCombinations(str, k);

    }


}
