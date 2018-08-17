package Expert;

import java.util.ArrayList;
import java.util.HashMap;

public class LetterPhone {


    HashMap<String, String> map = new HashMap<>();

    public ArrayList<String> letterCombinations(String A) {

        ArrayList<String> soln = new ArrayList<>();

        map.put("1", "1");
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        map.put("0", "0");


        String[] arr = new String[A.length()];
        for (int i = 0; i < A.length(); i++) {
            arr[i] = String.valueOf(A.charAt(i));
        }


        String a = map.get(arr[0]);
        for (int i = 0; i < a.length(); i++) {

            recur(String.valueOf(a.charAt(i)), 1, arr, soln, map);

        }

        return soln;
    }


    private void recur(String start, int index, String[] arr, ArrayList<String> soln, HashMap<String, String> map) {

        if (index == arr.length) {

            soln.add(start);

        }


        if (index < arr.length) {

            String a = map.get(arr[index]);
            for (int i = 0; i < a.length(); i++) {

                recur(start + String.valueOf(a.charAt(i)), index + 1, arr, soln, map);

            }


        }


    }


    public static void main(String[] args) {

        LetterPhone letterPhone = new LetterPhone();
        System.out.println(letterPhone.letterCombinations("333").toString());


    }

}
