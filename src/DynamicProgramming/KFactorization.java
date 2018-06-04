package DynamicProgramming;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KFactorization {

    private int key;
    private int[] a;
    private int count = 0;
    private HashMap<Integer, Boolean> hashMap = new HashMap<>();
    private PriorityQueue<String> fullExpCollection = new PriorityQueue<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    });


    private boolean backtrack(int sum, String fullExp) {

        if (hashMap.get(sum) != null) {
            return hashMap.get(sum);
        }

        count++;
        boolean c = false;
        for (int i = 0; i < a.length; i++) {
            sum = sum * a[i];
            String fullExpression = fullExp + " " + sum;
            if (sum < key) {
                c = backtrack(sum, fullExpression);
            }
            if (sum == key) {
                fullExpCollection.add(fullExpression);
                return true;
            }
            sum = sum / a[i];
        }

        hashMap.put(sum, c);
        return hashMap.get(sum);
        //return c;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        KFactorization kF = new KFactorization();
        kF.a = a;
        kF.key = key;
        kF.backtrack(1, "1");
        PriorityQueue<String> collection = kF.fullExpCollection;
        if (collection.size() == 0) {
            System.out.println("-1");
        } else {
            System.out.println(collection.peek());
        }

        System.out.println(kF.count);

    }

}
