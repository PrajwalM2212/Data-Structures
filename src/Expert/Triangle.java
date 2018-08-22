package Expert;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class Triangle {


    private static ArrayList<ArrayList<Integer>> triList;

    private int solve(int listNum, int i) {

        if (listNum == triList.size() - 1) {
            return triList.get(listNum).get(i);
        }

        return Math.min(triList.get(listNum).get(i) + solve(listNum + 1, i),
                triList.get(listNum).get(i) + solve(listNum + 1, i + 1));

    }

    public static void main(String[] args) {

        Triangle triangle = new Triangle();
        triangle.triList = new ArrayList<ArrayList<Integer>>();
        triList.add(new ArrayList<>(asList(2)));
        triList.add(new ArrayList<>(asList(3,4)));
        triList.add(new ArrayList<>(asList(6,5,7)));
        triList.add(new ArrayList<>(asList(4,1,8,3)));
        System.out.println(triangle.solve(0, 0));

    }
}
