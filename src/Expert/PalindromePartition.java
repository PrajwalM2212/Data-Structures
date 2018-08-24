package Expert;


public class PalindromePartition {


    private int solve(String start) {

        int min;
        if (start.equals("")) {
            min = 0;
        } else {
            min = 1000;
        }


        for (int i = 0; i < start.length(); i++) {

            if (isPalindrome(start.substring(0, i + 1))) {
                min = Math.min(min, 1 + solve(start.substring(i + 1)));
            }

        }

        return min;
    }


    private boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }


    public static void main(String[] args) {

        PalindromePartition partition = new PalindromePartition();
        System.out.println(partition.solve("abba"));

    }
}
