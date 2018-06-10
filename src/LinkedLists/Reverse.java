package LinkedLists;

import java.util.Scanner;
import java.util.Stack;

public class Reverse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            System.out.print(stack.pop());
        }
        scanner.close();
    }
}
