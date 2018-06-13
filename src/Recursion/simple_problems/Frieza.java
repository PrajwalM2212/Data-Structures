package Recursion.advanced_problems;


import java.util.Scanner;

public class Frieza {

    private String solve(String s) {

        for (int i = 0; i < s.length(); i++) {
            String frieza = "frieza";
            String q = Character.toString(s.charAt(i));
            if (frieza.contains(q)) {
                s = s.replace(q, "1");
            } else {
                if (!q.equals("0") && !q.equals("1")) {
                    s = s.replace(q, "0");
                }
            }
        }

        StringBuilder pin = new StringBuilder();
        int count = 1;
        for (int i = 0; i < s.length(); i++) {

            if (i < s.length() - 1) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    count = count + 1;
                } else {
                    pin.append(count);
                    count = 1;
                }
            } else {
                pin.append(count);
            }

        }


        return pin.toString();

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        String[] arr = new String[t];
        for (int i = 0; i < t; i++) {
            arr[i] = scanner.next();
        }
        Frieza frieza = new Frieza();
        for (int j = 0; j < t; j++) {
            System.out.println(frieza.solve(arr[j]));
        }
        scanner.close();

    }
}
