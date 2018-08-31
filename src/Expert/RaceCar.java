package Expert;

public class RaceCar {

    private int target;

    private int solve(int position, int speed) {

        // System.out.println(position + " " + speed);

        if (position == target) {
            return 0;
        }

        int a = 1 + solve(position += speed, speed *= 2);
        if (speed > 0) {
            speed = -1;
        } else {
            speed = 1;
        }
        int b = 1 + solve(position, speed);
        return Math.min(a, b);

    }


    public static void main(String[] args) {

        RaceCar raceCar = new RaceCar();
        raceCar.target = 6;
        System.out.println(raceCar.solve(0, 1));
    }


}
