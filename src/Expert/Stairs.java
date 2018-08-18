package Expert;

public class Stairs {


    private int cal(int n) {

        int[] arr = new int[n+1];

        arr[1] = 1;
        arr[2] = 2;

        return recur(n, arr);

    }


    private int recur(int n, int[] arr) {

        if (arr[n] != 0) {
            return arr[n];
        }

        if (n == 1) {
            return arr[0];
        }

        if (n == 2) {
            return arr[1];
        }

        arr[n] = recur(n - 1, arr) + recur(n - 2, arr);
        return arr[n];

    }


    public static void main(String[] args) {

        System.out.println(new Stairs().cal(5));
    }


}
