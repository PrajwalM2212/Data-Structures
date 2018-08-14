package Expert;

import java.util.Scanner;

public class SubsetSum {


    private void solve(String str, int sum) {

        for (int i = 0; i < str.length(); i++) {

            recur(Integer.valueOf(String.valueOf(str.charAt(i))), str.substring(i), sum, String.valueOf(str.charAt(i)));

        }

    }

    private void recur(int startNum, String remaining, int sum, String expression) {


        if (startNum < sum) {

            for (int i = 0; i < remaining.length(); i++) {

                if (Integer.valueOf(String.valueOf(expression.charAt(expression.length() - 1))) <= Integer.valueOf(String.valueOf(remaining.charAt(i)))) {

                    recur(startNum + Integer.valueOf(String.valueOf(remaining.charAt(i))), remaining, sum, expression + String.valueOf(remaining.charAt(i)));

                }

            }


        } else if (startNum == sum) {

            System.out.println(expression);

        }

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int sum = scanner.nextInt();
        scanner.close();
        SubsetSum subsetSum = new SubsetSum();
        subsetSum.solve(str, sum);


    }


}
