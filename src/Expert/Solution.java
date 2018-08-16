package Expert;

import java.util.ArrayList;

public class Solution {

    private ArrayList<ArrayList<Integer>> soln = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {

        ArrayList<Integer> a = new ArrayList<>();
        soln.add(a);

        for (int i = 0; i < A.size(); i++) {

            if (i <= A.size() - 1) {
                recur(A.get(i), A, i + 1);

            } else {

                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(A.get(i));
                soln.add(ans);

            }


        }


        return soln;
    }


    private void recur(int start, ArrayList<Integer> arr, int index) {

        if (index <= arr.size()) {

            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(start);
            soln.add(ans);

            for (int i = index; i < arr.size(); i++) {

                String s = String.valueOf(start);
                String a = String.valueOf(arr.get(i));
                int value = Integer.valueOf(s + a);

                recur(value, arr, i + 1);


            }

        }

    }


    public static void main(String[] args){

        Solution solution = new Solution();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        ArrayList<ArrayList<Integer>> sol = solution.subsets(list);

        System.out.print(sol.toString());


    }
}
