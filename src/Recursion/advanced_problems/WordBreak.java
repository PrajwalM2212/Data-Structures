package Recursion.advanced_problems;

import java.util.Scanner;

public class WordBreak {

    private boolean solve(String inputWord, String[] words) {


        boolean ispossible = false;
        System.out.println(inputWord);
        if (inputWord.length() == 0 || inputWord.equals("")) {
            return true;
        }

        for (String word : words) {
            int len = word.length();
            if (inputWord.length() >= len) {
                if (inputWord.substring(0, len).equals(word)) {
                    ispossible = solve(inputWord.substring(len), words);
                }
            }
        }

        return ispossible;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = scan.next();
            }
            String inputWord = scanner.next();
            WordBreak wordBreak = new WordBreak();
            if (wordBreak.solve(inputWord, words)) {
                System.out.println(1);
            } else {
                System.out.println(0);
                t--;
            }
            scan.close();
        }
        scanner.close();
    }
}
