package Expert;

public class PalindromeSubsequence {

    String s;
    int count = 0;

    public PalindromeSubsequence(String s) {
        this.s = s;
    }

    private int solve(int i, int j, int[][] cache) {

        if (cache[i][j] != 0) {
            return cache[i][j];
        }

        count++;
        // if only one element is left
        if (i == j) {
            return cache[i][j] = 1;
        }


        // if last two elements are equal
        if (s.charAt(i) == s.charAt(j)) {
            return cache[i][j] = 2 + solve(i + 1, j - 1, cache);
        }


        //if the final pair is a palindrome
        if (i == j - 1 && s.charAt(i) == s.charAt(j)) {
            return cache[i][j] = 2;
        }

        //if last two elements are not equal
        return cache[i][j] = Math.max(solve(i + 1, j, cache), solve(i, j - 1, cache));

    }


    public static void main(String[] args) {

        PalindromeSubsequence subsequence = new PalindromeSubsequence("BBABCBCABBAB");
        System.out.println(subsequence.solve(0, subsequence.s.length() - 1, new int[subsequence.s.length()][subsequence.s.length()]));
        System.out.println("Number of recursive calls " + subsequence.count);

    }
}
