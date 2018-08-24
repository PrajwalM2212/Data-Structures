package DPproblems;

public class LIS {

    int[] values;
    int count = 0;

    private int solve(int index, int[] cache) {

        if (cache[index] != 0) {
            return cache[index];
        }
        count++;

        int max = 0;

        if (index == values.length) {

            // choosing a starting position external to array. We assume all
            // sub sequences start with negative infinity(lowest number)
            for (int i = 0; i < values.length; i++) {

                if (values[i] >= Integer.MIN_VALUE) {

                    max = Math.max(max, solve(i, cache));

                }

            }

        } else {

            // defining that states are defined by index, we move from state to state. The cost of moving
            // from one state to another is taken as 1

            for (int i = index; i < values.length; i++) {

                if (values[i] > values[index]) {

                    max = Math.max(max, 1 + solve(i, cache));

                }

            }

        }

        return cache[index] = max;

    }


    public static void main(String[] args) {

        LIS lis = new LIS();
        lis.values = new int[]{10, 9, 3, 5, 4, 11, 7, 8};
        // choose cache with size one more than the size of values array as we start from negative infinity
        System.out.println(lis.solve(8, new int[9]) + 1);
        System.out.println("Number of recursive calls " + lis.count);

    }


}
