package Maths;

public class SquareRoot {

    public static double sqrt(int number) {
        if(number <= 0){ return 0;}
        if(number == 1){ return 1;}
        double t;
        double squareRoot = number / 2;
        do {
            t = squareRoot;
            squareRoot = (t + (number / t)) / 2;
        } while ((t - squareRoot) != 0);

        return squareRoot;
    }
    
    public static void main(String[] args) {
        System.out.println(sqrt(4));
    }
}
