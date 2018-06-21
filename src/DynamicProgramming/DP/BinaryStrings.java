package DynamicProgramming.DP;

import java.util.Scanner;

public class BinaryStrings {


    private int c;
    private int size;

    private void calc(boolean hasOne, String s) {

        if (s.length() == size) {
            c++;
           // System.out.println(s);
        }

        if (s.length() < size) {
            if (hasOne) {
                calc(false, s + "0");
            } else {
                calc(false, s + "0");
                calc(true, s + "1");
            }
        }

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {
            int size = scanner.nextInt();
            BinaryStrings binary = new BinaryStrings();
            binary.size = size;
            binary.c = 0;
            binary.calc(false, "");
            System.out.println(binary.c);
            t--;
        }

    }
}
