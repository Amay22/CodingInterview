package maths;

public class Power {

    public static double power(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double v = power(x, n / 2);
        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }

    public static double pow(double x, int n) {

        if (n < 0) {
            return 1 / power(x, -n);
        } else {
            return power(x, n);
        }
    }

    public static void main(String[] args) {
        System.out.println(pow(12, -6));
    }
}
