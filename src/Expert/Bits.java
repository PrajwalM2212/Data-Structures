package Expert;

public class Bits {

    String s;

    public Bits(String s) {
        this.s = s;
    }


    // here i and j represents the string between i and j
    private int solve(int i, int j, int[][] cache) {

        // if already solved do not solve again(This is done to prevent duplicate values)
        if (cache[i][j] == 0) {

            int cost = 0;

            if (i < s.length() && j >= 0) {

                if (s.charAt(i) == '0' && s.charAt(j) == '1') {
                    System.out.println((i) + " " + (j));
                    cost = 1;
                }
            }

            int a = 0, b = 0;
            if (i < s.length()) {
                a = solve(i + 1, j, cache);
            }

            if (j > 0) {
                b = solve(i, j - 1, cache);
            }
            return cache[i][j] = cost + a + b;
        }

        return 0;

    }


    public static void main(String[] args) {
        Bits bits = new Bits("0011");
        System.out.println(bits.solve(0, bits.s.length() - 1, new int[6][6]));

    }
}
