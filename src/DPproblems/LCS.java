package DPproblems;

public class LCS {

    String s1;
    String s2;
    int count = 0;

    private int solve(int i, int j, int[][] cache) {

        if (cache[i][j] != 0) {
            return cache[i][j];
        }

        count++;


        if (i == s1.length() || j == s2.length()) {

            return cache[i][j] = 0;

        }


        if (s1.charAt(i) == s2.charAt(j)) {

            return cache[i][j] = 1 + solve(i + 1, j + 1, cache);

        } else {

            return cache[i][j] = Math.max(solve(i, j + 1, cache), solve(i + 1, j, cache));

        }


    }


    public static void main(String[] args) {

        LCS lcs = new LCS();
        lcs.s1 = "hello";
        lcs.s2 = "trello";
        System.out.println(lcs.solve(0, 0, new int[lcs.s1.length() + 1][lcs.s2.length() + 1]));
        System.out.println("Number of recursive calls " + lcs.count);

    }


}
