package Expert;

import java.util.Scanner;

public class Combinations {


    private void genCombinations(String str, int k) {

        for (int i = 0; i < str.length(); i++) {

            recur(String.valueOf(str.charAt(i)), str.substring(i + 1), k);

        }

    }

    private void recur(String start, String remaining, int k) {

        if (start.length() < k) {

            for (int i = 0; i < remaining.length(); i++) {

                recur(start + String.valueOf(remaining.charAt(i)), remaining.substring(i + 1), k);

            }


        } else {

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
