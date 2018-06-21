package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TimeSaving {


    private int n;
    private int[][] alreadyTravelled;

    private long timeTaken(int rowIndex, int[][] matrix, int k, int timeSoFar, int from) {

        System.out.println(from + "," + rowIndex);
        if (rowIndex == n - 1) {
            return timeSoFar;
        }

        ArrayList<Long> timeTaken = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[rowIndex][i] != 0 && i != from) {
                if (alreadyTravelled[rowIndex][i] == 1) {
                    return Integer.MAX_VALUE;
                }
                if (timeSoFar % k == 0) {
                    int travelTime = k + matrix[rowIndex][i];
                    alreadyTravelled[rowIndex][i] = 1;
                    timeTaken.add(travelTime + timeTaken(i, matrix, k, travelTime + timeSoFar, rowIndex));
                } else {
                    alreadyTravelled[rowIndex][i] = 1;
                    timeTaken.add(matrix[rowIndex][i] + timeTaken(i, matrix, k, matrix[rowIndex][i] + timeSoFar, rowIndex));
                }
            }
        }

        Collections.sort(timeTaken);
        if (timeTaken.size() > 0) {
            return timeTaken.get(0);
        } else {
            return Integer.MAX_VALUE;
        }
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
        System.out.println(timeSaving.timeTaken(0, matrix, k, 0, -1));

    }
}
