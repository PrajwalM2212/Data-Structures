package CodeChef;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Good {

    HashSet<int[]> set = new HashSet<>();

    private void solve(int[] a, ArrayList<Integer> al, int alk, int k) {

        for (int j = 1; j <= a.length; j++) {

            a[al.get(alk)] = j;

            if (alk < al.size() - 1) {
                solve(a, al, alk + 1, k);
            }


            if (isUnique(a, k)) {

                set.add(a);
                for (int e : a) {
                    System.out.println(e);
                }

            }
        }
    }

    private boolean isUnique(int[] a, int k) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }


        int c = 0;
        for (int r = 1; r < a.length; r++) {
            if (a[r] > a[r - 1]) {
                c++;
            }
        }


        return a.length == set.size() && c == k;
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
            good.solve(a, al, 0, k);
            System.out.println(good.set.size());
            t--;
        }
    }
}
