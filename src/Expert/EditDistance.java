package Expert;

public class EditDistance {

    String source;
    String destination;
    int count = 0;

    private int solve(int i, int j, int[][] cache) {

        if (cache[i][j] != 0) {
            return cache[i][j];
        }

        count++;

        // all chars deleted and hence we only insert all
        if (i == source.length()) {
            return cache[i][j] = destination.length() - j;
        }

        // all chars inserted and hence we can only delete all
        if (j == destination.length()) {
            return cache[i][j] = source.length() - i;
        }


        if (source.charAt(i) == destination.charAt(j)) {
            return cache[i][j] = solve(i + 1, j + 1, cache);
        }


        // delete,insert,replace
        return cache[i][j] = Math.min(1 + solve(i + 1, j, cache), Math.min(1 + solve(i, j + 1, cache), 1 + solve(i + 1, j + 1, cache)));


    }


    public static void main(String[] args) {

        EditDistance editDistance = new EditDistance();
        editDistance.source = "sunday";
        editDistance.destination = "saturday";
        System.out.println(editDistance.solve(0, 0,new int[editDistance.source.length()+1][editDistance.destination.length()+1]));
        System.out.println("Number of recursive calls " + editDistance.count);

    }
}
