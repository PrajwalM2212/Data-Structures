package Expert;

import java.util.ArrayList;

public class Solution2 {


    private ArrayList<ArrayList<Integer>> solve(int A, int B) {


        ArrayList<Integer> store = new ArrayList<>();
        for (int i = 1; i <= A; i++) {
            store.add(i);
        }


        ArrayList<ArrayList<Integer>> soln = new ArrayList<>();

        if (A < B) {

            return soln;
        }

        for (int i = 0; i < store.size(); i++) {

            ArrayList<Integer> combi = new ArrayList<>();
            combi.add(store.get(i));
            if (B == 1) {
                soln.add(combi);
            }

            recur(store, soln, combi, i + 1, B);


        }

        return soln;

    }


    private void recur(ArrayList<Integer> store, ArrayList<ArrayList<Integer>> soln, ArrayList<Integer> combi, int index, int k) {



        for (int i = index; i < store.size(); i++) {

            if (combi.size() < k) {

                ArrayList<Integer> got = new ArrayList<>();

                for (int e : combi) {
                    got.add(e);
                }

                got.add(store.get(i));
                if(got.size() == k ){
                    soln.add(got);
                }

                recur(store, soln, got, i + 1, k);
            }

        }


    }


    public static void main(String[] args) {

        Solution2 solution = new Solution2();
        ArrayList<ArrayList<Integer>> sol = solution.solve(4, 2);

        System.out.print(sol.toString());


    }


}
