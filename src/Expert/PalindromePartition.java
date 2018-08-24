package Expert;


public class PalindromePartition {

    private String start;
    private int count = 0;

    public PalindromePartition(String start) {

        this.start = start;


    }

    private int solve(int index, int[] cache) {

        if (cache[index] != 0) {
            return cache[index];
        }

        count++;
        int min;
        if (index == start.length()) {
            min = 0;
        } else {
            min = 1000;
        }


        for (int i = index; i < start.length(); i++) {

            if (isPalindrome(start.substring(index, i + 1))) {
                min = Math.min(min, 1 + solve(i + 1, cache));
            }

        }

        return cache[index] = min;
    }


    private boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }


    public static void main(String[] args) {

        String start = "abbabb";
        PalindromePartition partition = new PalindromePartition(start);
        System.out.println(partition.solve(0, new int[start.length() + 1]));
        System.out.println("The number of recursive calls " + partition.count);

    }
}
