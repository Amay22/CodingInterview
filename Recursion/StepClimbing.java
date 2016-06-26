package Recursion;


public class StepClimbing {
    public static int climb(int n){
        if( n < 0 ){
            return 0;
        }else if( n == 0 ){            
            return 1;
        }else{
            return climb(n-1) + climb(n-2);
        }
    }
    public static void main(String[] args) {
        System.out.println(climb(4));
    }
}
