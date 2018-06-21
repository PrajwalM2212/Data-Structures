package Recursion.advanced_problems;


import java.util.HashSet;
import java.util.Scanner;

public class StringPermutation {


    private char[] str;

    private void solve(char[] arr, int count) {

        for (int j = 0; j < arr.length; j++) {
            str[count] = arr[j];
            if (count == arr.length - 1) {
                HashSet<Character> set = new HashSet<>();
                for (char e : str) {
                    set.add(e);
                }
                if (set.size() == str.length) {
                    for (char e : str) {
                        System.out.print(e);
                    }
                    System.out.print(" ");
                }
            }
            if (count < arr.length - 1) {
                solve(arr, count + 1);
            }
        }
    }

    private int fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * fact(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] string = new char[str.length()];
        StringPermutation permutation = new StringPermutation();
        permutation.str = string;
        System.out.println(permutation.fact(string.length));
        permutation.solve(str.toCharArray(), 0);
        scanner.close();
    }
}
