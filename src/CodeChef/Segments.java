package CodeChef;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Segments {


    private int solve(int[] a, int[] b, int k) {

        int c = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] >= a[a.length - 1]) {
                break;
            }
            int count = 1;
            int q = b[i];
            for (int j = a.length - 1; j >= 0; j--) {

                if (a[j] > q) {
                    count++;
                } else {
                    break;
                }

                if (count >= k) {
                    c = (c + 1) % 1000000007;
                    count = 1;
                }

            }
        }

        return c;
    }

    public static void main(String[] args) throws IOException {
       // Scanner scanner = new Scanner(System.in);
        //int t = scanner.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer("");
        token = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(token.nextToken());
        while (t > 0) {
            token = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(token.nextToken());
            int k = Integer.parseInt(token.nextToken());
            // int n = scanner.nextInt();
            // int k = scanner.nextInt();

            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                token = new StringTokenizer(br.readLine());
                a[i] = Integer.parseInt(token.nextToken());//scanner.nextInt();
                b[i] = Integer.parseInt(token.nextToken());//scanner.nextInt();
            }
            Segments segments = new Segments();
            Arrays.sort(a);
            Arrays.sort(b);
            System.out.println(segments.solve(a, b, k));
            t--;
        }
    }
}

/*public class Segments {

    private int solve(int[][] arr, int k) {

        int c = 0;

        for (int i = 0; i < arr.length; i++) {

            int q = arr[i][1];
           // System.out.println(q);
            int count = 1;
            for (int j = 0; j < arr.length; j++) {

                if (arr[j][0]>q) {
                    count = count + 1;
                   // System.out.println(arr[j][0]);
                }

                if (count >= k) {
                    c = c + 1;
                    count = 1;
                }

            }
           // System.out.println("\n");

        }

        return c;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = scanner.nextInt();
                arr[i][1] = scanner.nextInt();
            }
            Segments segments = new Segments();
            System.out.println(segments.solve(arr, k));
            t--;
        }
    }
}*/
