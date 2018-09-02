package Expert;

public class DecodeWays {


    int[] cache;
    int count = 0;

    private int solve(String s, int index) {


        if (cache[index] != 0) {
            return cache[index];
        }

        count++;

        if (s.length() == 1 && s.equals("*")) {
            return cache[index] = 9;
        }

        if (s.length() == 1) {
            return cache[index] = 1;
        }


        if (s.length() == 2 && s.contains("*") && s.substring(0, 1).equals("*")) {

            if (Integer.valueOf(s.substring(1, 2)) <= 2) {
                return cache[index] = 2 + 9;
            }

            if (Integer.valueOf(s.substring(1, 2)) > 2) {
                return cache[index] = 1 + 9;
            }
        }

        if (s.length() == 2 && s.contains("*") && Integer.valueOf(s.substring(0, 1)) <= 2) {

            if (Integer.valueOf(s.substring(0, 1)) == 2) {
                return cache[index] = 6;
            }

            if (Integer.valueOf(s.substring(0, 1)) == 1) {
                return cache[index] = 9;
            }
        }


        if (s.length() == 2 && s.contains("*") && Integer.valueOf(s.substring(0, 1)) > 2) {

            return cache[index] = 0;
        }


        if (s.length() == 2 && Integer.valueOf(s) <= 26) {

            return cache[index] = 1 + solve(s.substring(1), index + 1);

        }

        if (s.length() == 2 && Integer.valueOf(s) > 26) {

            return cache[index] = solve(s.substring(1), index + 1);

        }


        return cache[index] = solve(s.substring(1), index + 1) + solve(s.substring(2), index + 2);

    }

    public static void main(String[] args) {

        DecodeWays decodeWays = new DecodeWays();
        String str = "1234*";
        decodeWays.cache = new int[str.length()];
        System.out.println(decodeWays.solve(str, 0));
        System.out.println("Number of recursive calls: " + decodeWays.count);

    }
}
