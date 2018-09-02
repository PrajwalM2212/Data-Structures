package DynamicProgramming;

import java.util.HashMap;

public class RaceCar {

    private int target;
    private HashMap<Integer, Integer>[] map;

    private int solve(int position, int speed) {

        if (map[position].get(speed) != null) {
            return map[target].get(speed);
        }


        System.out.println(position + " " + speed);

        if (position == target) {
            return 0;
        }

        int b = 0;
        int a = 0;
        int c = 0;
        if (position > target && speed >= 0) {

            b = 1 + solve(position, -1);

        } else if (position < target && speed < 0) {

            b = 1 + solve(position, 1);

        } else {

            a = 1 + solve(position += speed, speed *= 2);

            if (speed >= 0) {
                c = 1 + solve(position, -1);
            } else {
                c = 1 + solve(position, 1);
            }


        }

        map[position].put(speed, Math.min(a, c) + b);

        return Math.min(a, c) + b;

    }


    public static void main(String[] args) {

        RaceCar raceCar = new RaceCar();
        raceCar.target = 5;
        HashMap<Integer, Integer>[] map = new HashMap[100];
        for (int i =0;i<100;i++){
            map[i] = new HashMap<>();
        }
        raceCar.map = map;
        System.out.println(raceCar.solve(0, 1));

    }


}
