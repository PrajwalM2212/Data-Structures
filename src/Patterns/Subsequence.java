package Patterns;

import java.util.ArrayList;
import java.util.Scanner;

/*
Subsequence problems are very common in dynamic programming. A common hurdle when implementing is that data structures are not cloned. It is
better to make a clone(shallow or deep copy)

Store all elements is a arraylist and choose empty string as a input .

// Recursion block
// loop through all elements.
// At each loop clone a new list . remove a element from the cloned list. append the removed element to the input. call the function again with cloned list and new input

 */


public class Subsequence {

    private void genSub(String input, ArrayList<String> arrayList) {

        for (int i = 0; i < arrayList.size(); i++) {

            ArrayList<String> newList = (ArrayList<String>) arrayList.clone();
            String element = newList.remove(i);
            String output = input + element;
            System.out.println(output);
            genSub(output, newList);

        }

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numElements = scanner.nextInt();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < numElements; i++) {

            list.add(scanner.next());

        }

        Subsequence sQ = new Subsequence();
        sQ.genSub("", list);

    }
}
