package UnderstandingDP;

import java.util.Arrays;
import java.util.Scanner;

public class STR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        while (q > 0) {
            String a = scanner.next().trim();
            String b = scanner.next().trim();
            String l = b;
            String g = b;
            String s = a;
            boolean[] arr = new boolean[b.length()];
            Arrays.fill(arr, Boolean.FALSE);
            int count = 0;
            int c = 0;
            a = a.toUpperCase();
            for (int i = 0; i < b.length(); i++) {
                for (int j = 0; j < a.length(); j++) {
                    if (b.charAt(i) == a.charAt(j)) {
                        StringBuilder sb = new StringBuilder(a);
                        sb.setCharAt(i, '\0');
                        a = sb.toString();
                        arr[i] = true;
                    }
                }
            }


            s = s.replaceAll("[a-z]+", "");
            boolean[] ar = new boolean[s.length()];
            Arrays.fill(ar, Boolean.FALSE);
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < l.length(); j++) {
                    if (s.charAt(i) == l.charAt(j)) {
                        StringBuilder sb = new StringBuilder(l);
                        sb.setCharAt(j, '\0');
                        l = sb.toString();
                        ar[i] = true;
                    }
                }
            }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i]) {
                    count++;
                }
            }

            for (int i = 0; i < ar.length; i++) {
                if (ar[i]) {
                    c++;
                }
            }
            if (count == g.length() && c == ar.length) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            q--;
        }

    }

}
