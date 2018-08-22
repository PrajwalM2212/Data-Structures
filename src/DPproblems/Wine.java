package DPproblems;

import java.util.HashMap;

public class Wine {

    // top-down approach
    private int solve(String arrangement, int year, HashMap<String, Integer> map) {

        if (map.get(arrangement) != null) {
            return map.get(arrangement);
        }

        if (arrangement.length() == 0) {
            return 0;
        }


        map.put(arrangement, Math.max((Integer.valueOf(String.valueOf(arrangement.charAt(0))) * year) + solve(arrangement.substring(1), year + 1, map),
                (Integer.valueOf(String.valueOf(arrangement.charAt(arrangement.length() - 1))) * year) + solve(arrangement.substring(0, arrangement.length() - 1), year + 1, map)));

        return map.get(arrangement);

    }

    // bottom-up approach
    public static void main(String[] args) {
        System.out.println(new Wine().solve("234542331", 1, new HashMap<>()));
    }
}
