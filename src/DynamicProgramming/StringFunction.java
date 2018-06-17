package DynamicProgramming;

import java.util.HashMap;
import java.util.Scanner;

public class StringFunction {

    private HashMap<String, Integer> hashMap = new HashMap<>();

    private int solve(String s) {
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= s.length(); i++) {
            max = Math.max(max, recur(s, i, s));
        }
        return max;
    }

    private int recur(String str, int k, String s) {

        int max = Integer.MIN_VALUE;
        if (str.length() <= k) {
           // System.out.println(str);
            if (hashMap.get(str) != null) {
                int c = hashMap.get(str);
              //  System.out.println(c);
                hashMap.put(str, c + str.length());
                max = Math.max(max, hashMap.get(str));
            } else {
                hashMap.putIfAbsent(str, str.length());
                max = Math.max(max, hashMap.get(str));
            }

            return max;
        }

        String a = str.substring(0, k);
       // System.out.println(a);
        if (hashMap.get(a) != null) {
            int c = hashMap.get(a);
          //  System.out.println(c);
            hashMap.put(a, c + a.length());
            max = Math.max(max, hashMap.get(a));
        } else {
            hashMap.putIfAbsent(a, a.length());
            max = Math.max(max, hashMap.get(a));
        }

        return Math.max(max, recur(str.substring(1), k, s));

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        scanner.close();
        StringFunction stringFunction = new StringFunction();
        System.out.println(stringFunction.solve(s));
        // System.out.println(stringFunction.contains("abc", "abcabcdabc"));
    }
}
