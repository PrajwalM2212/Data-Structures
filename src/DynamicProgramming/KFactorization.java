package DynamicProgramming;

import java.util.*;

public class KFactorization {

    private int key;
    private int count = 0;
    private HashMap<Integer, Boolean> hashMap = new HashMap<>();
    private PriorityQueue<String> fullExpCollection = new PriorityQueue<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    });

    private boolean backtrack(int[] a, int sum, String fullExp) {

        if (hashMap.get(sum) != null) {
            return hashMap.get(sum);
        }

        count++;
        boolean c = false;
        for (int i = 0; i < a.length; i++) {
            sum = sum * a[i];
            int[] arr = new int[a.length - 1];
            System.arraycopy(a, 0, arr, 0, i);
            System.arraycopy(a, i + 1, arr, i + 1 - 1, a.length - (i + 1));
            String fullExpression = fullExp + " " + sum;
            if (sum < key) {
                c = backtrack(arr, sum, fullExpression);
            }
            if (sum == key) {
                fullExpCollection.add(fullExpression);
                return true;
            }
            sum = sum / a[i];
        }

        hashMap.put(sum, c);
        return hashMap.get(sum);
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
        kF.key = key;
        kF.backtrack(a, 1, "1");
        PriorityQueue<String> collection = kF.fullExpCollection;
        if (collection.size() == 0) {
            System.out.println("-1");
        } else {
            System.out.println(collection.peek());
        }

        System.out.println(kF.count);

    }

}
