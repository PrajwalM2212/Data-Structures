package Expert;

import java.util.ArrayList;

public class Solution {


    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> soln = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        soln.add(a);

        for (int i = 0; i < A.size(); i++) {

            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(A.get(i));
            soln.add(arr);

            ArrayList<Integer> pass = new ArrayList<>();
            pass.add(arr.get(0));
            recur(pass, A, soln, i + 1);

        }


        return soln;
    }


    private void recur(ArrayList<Integer> start, ArrayList<Integer> A, ArrayList<ArrayList<Integer>> soln, int index) {


        for (int i = index; i < A.size(); i++) {

            start.add(A.get(index));
            soln.add(start);


            ArrayList<Integer> pass = new ArrayList<>();
            for (int e : start) {
                pass.add(e);
            }
            recur(pass, A, soln, i + 1);
        }

    }


    public static void main(String[] args) {

        Solution solution = new Solution();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        ArrayList<ArrayList<Integer>> sol = solution.subsets(list);

        System.out.print(sol.toString());


    }
}
