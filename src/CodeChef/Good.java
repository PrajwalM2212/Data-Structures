package CodeChef;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Good {

    private int solve(int[] a, ArrayList<Integer> al, int alk, int k) {

        int s = 0;
        for (int j = 1; j <= a.length; j++) {

            a[al.get(alk)] = j;

            if (alk < al.size() - 1) {
                s = s + solve(a, al, alk + 1, k);
            }


            if (isUnique(a)) {
                int c = 0;
                for (int r = 1; r < a.length; r++) {
                    if (a[r] > a[r - 1]) {
                        c++;
                    }
                }
                if (c == k) {
                    s = s + 1;
                    for (int e : a) {
                        System.out.println(e);
                    }
                }
            }

        }
        return s;
    }

    private boolean isUnique(int[] a) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < a.length; i++) {

            set.add(a[i]);
        }
        return a.length == set.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[n];
            ArrayList<Integer> al = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            for (int i = 0; i < n; i++) {
                if (a[i] == 0) {
                    al.add(i);
                }
            }
            Good good = new Good();
            System.out.println(good.solve(a, al, 0, k));
            t--;
        }
    }
}
