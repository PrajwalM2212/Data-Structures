package Recursion.advanced_problems;

import java.util.*;

public class KFactorization {

   // private ArrayList<String> expCollection = new ArrayList<>();
    private ArrayList<String> fullExpCollection = new ArrayList<>();

    private void factRec(int[] a, int length, int key, int feed, String exp, String fullExp) {

        for (int i = 0; i < length; i++) {
            int newFeed = feed * a[i];
            String expression = exp + " " + a[i];
            String fullExpression = fullExp + " " + newFeed;
            if (newFeed > key) {
                break;
            }
            if (newFeed == key) {
               // System.out.println(feed + " " + a[i]);
               // System.out.println(expression);
               // System.out.println(fullExpression);
               // expCollection.add(expression);
                fullExpCollection.add(fullExpression);
               // System.out.println("\n");
            }
            factRec(a, length, key, newFeed, expression, fullExpression);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        scanner.close();
        KFactorization kF = new KFactorization();
        kF.factRec(a, a.length, key, 1, "1", "1");
        ArrayList<String> collection = kF.fullExpCollection;
        collection.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        if (collection.size() == 0) {
            System.out.println("-1");
        } else {
            System.out.println(collection.get(0));
        }
    }
}
