package Expert;

import java.util.ArrayList;

public class CombinationSum {


    private ArrayList<ArrayList<Integer>> subsetSum(ArrayList<Integer> data, int des) {

        ArrayList<ArrayList<Integer>> solution = new ArrayList<>();


        for (int i = 0; i < data.size(); i++) {

            ArrayList<Integer> list = new ArrayList<>();
            list.add(data.get(i));
            recur(data.get(i), data, i + 1, solution, list, des);

        }


        return solution;


    }

    private void recur(int sum, ArrayList<Integer> data, int index, ArrayList<ArrayList<Integer>> solution, ArrayList<Integer> temp, int des) {

        if (sum == des) {

            solution.add(temp);

        }


        if (sum < des) {

            for (int i = index; i < data.size(); i++) {

                temp.add(data.get(i));
                recur(sum + data.get(i), data, index, solution, new ArrayList<>(temp), des);
                temp.remove(temp.size() - 1);


            }


        }


    }


    public static void main(String[] args) {

        CombinationSum cSum = new CombinationSum();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(7);
        System.out.println(cSum.subsetSum(list, 7).toString());

    }


}
