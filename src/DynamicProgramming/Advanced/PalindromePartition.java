package DynamicProgramming.Advanced;

import java.util.HashMap;
import java.util.Scanner;

import static java.lang.System.out;

public class PalindromePartition {

    private HashMap<String, Integer> map = new HashMap<>();

    private int pSplit(String word) {

        if (map.get(word) != null) {
            return map.get(word);
        }

        int min = Integer.MAX_VALUE;
        if (isPalindrome(word)) {
            map.put(word, 0);
            return map.get(word);
        }

        for (int i = 0; i < word.length() - 1; i++) {
            min = Math.min(min, 1 + (pSplit(word.substring(0, i + 1)) + pSplit(word.substring(i + 1))));
        }

        map.put(word, min);
        return map.get(word);


    }


    private boolean isPalindrome(String str) {
        StringBuilder builder = new StringBuilder(str);
        String revStr = builder.reverse().toString();
        return revStr.equals(str);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t > 0) {
            String word = scanner.next();
            PalindromePartition partition = new PalindromePartition();
            out.println(partition.pSplit(word));
            t--;
        }
        scanner.close();


    }

}

