package DynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class Reverse {

    private ArrayList<Integer> arrayList = new ArrayList<>();

    private void dynamic(int k, String n) {
        boolean solvable = false;
        for (int i = 0; i <= 9; i++) {
            arrayList.add(k, i);
            if (k < n.length() - 1) {
                dynamic(k + 1, n);
            }
            if (k == n.length() - 1) {
                StringBuilder sb = new StringBuilder();
                for (int e : arrayList) {
                    sb.append(e);
                }

                if (n.equals(sb.reverse().toString())) {
                    System.out.println(sb.reverse().toString());
                }

            }
            arrayList.remove(k);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        Reverse reverse = new Reverse();
        reverse.dynamic(0, n);
        scanner.close();
    }
}
