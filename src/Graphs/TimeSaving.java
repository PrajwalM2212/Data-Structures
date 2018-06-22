package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TimeSaving {


    private int n;
    private int[][] alreadyTravelled;
    private int k;
    private ArrayList<Long> time;

    private void timeTaken(int rowIndex, int[][] matrix, long timeSoFar, int from) {

       // System.out.println(from + "," + rowIndex + "," + timeSoFar);

        // ArrayList<Long> timeTaken = new ArrayList<>();
        //  long[] timeTake = new long[n];
        if (rowIndex == n - 1) {
            //  Arrays.fill(timeTake, 0);
            time.add(timeSoFar);
        }

        if (rowIndex < n - 1) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[rowIndex][i] != 0 && i != from) {
                    if (alreadyTravelled[rowIndex][i] == 1) {
                        //return Integer.MAX_VALUE;
                        //timeTake[i] = Integer.MAX_VALUE;

                    } else if (timeSoFar >=4 && ((timeSoFar/k)%2!=0)) {
                        long signalTime= k-(timeSoFar%k);
                        long travelTime = signalTime + matrix[rowIndex][i];
                        alreadyTravelled[rowIndex][i] = 1;
                        // timeTaken.add(travelTime + timeTaken(i, matrix, k, travelTime + timeSoFar, rowIndex));
                        // timeTake[i] = travelTime + timeTaken(i, matrix, travelTime + timeSoFar, rowIndex)[i];
                        timeTaken(i, matrix, travelTime + timeSoFar, rowIndex);


                    } else {
                        alreadyTravelled[rowIndex][i] = 1;
                        // timeTaken.add(matrix[rowIndex][i] + timeTaken(i, matrix, k, matrix[rowIndex][i] + timeSoFar, rowIndex));
                        // timeTake[i] = matrix[rowIndex][i] + timeTaken(i, matrix, matrix[rowIndex][i] + timeSoFar, rowIndex)[i];
                        timeTaken(i, matrix, matrix[rowIndex][i] + timeSoFar, rowIndex);
                    }
                }
            }
        }

      /*  Collections.sort(timeTaken);
        if (timeTaken.size() > 0) {
            return timeTaken.get(0);
        } else {
            return Integer.MAX_VALUE;
        }*/
        // return timeTake;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] matrix = new int[n][n];
        for (int q = 0; q < m; q++) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            int time = scanner.nextInt();
            matrix[i - 1][j - 1] = time;
            matrix[j - 1][i - 1] = time;
        }

        int[][] aT = new int[n][n];
        TimeSaving timeSaving = new TimeSaving();
        timeSaving.n = n;
        timeSaving.alreadyTravelled = aT;
        timeSaving.k = k;
        timeSaving.time = new ArrayList<>();
        timeSaving.timeTaken(0, matrix, 0, -1);
        Collections.sort(timeSaving.time);
        System.out.println(timeSaving.time.get(0));


    }
}
