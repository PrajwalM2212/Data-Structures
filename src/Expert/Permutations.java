package Expert;

import java.util.ArrayList;

public class Permutations {

    private ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> data) {

        ArrayList<ArrayList<Integer>> solution = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {

            ArrayList<Integer> list = new ArrayList<>();
            list.add(data.get(i));
            // create new array list( alternatively refer 38)
            ArrayList<Integer> newData = new ArrayList<>(data);
            newData.remove(i);
            recur(newData, list, solution);

        }

        return solution;
    }


    private void recur(ArrayList<Integer> data, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> solution) {


        if (data.size() == 0) {
            solution.add(list);
        }


        for (int i = 0; i < data.size(); i++) {

            list.add(data.get(i));
            // remove element from data and then re-add after recursive call ( alternatively refer 16)
            int e = data.remove(i);
            recur(new ArrayList<>(data), new ArrayList<>(list), solution);
            data.add(i, e);
            list.remove(list.size() - 1);

        }


    }


    public static void main(String[] args) {

        Permutations perm = new Permutations();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(perm.permute(list).toString());

    }


}
