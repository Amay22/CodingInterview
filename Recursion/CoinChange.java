package Recursion;

public class CoinChange {

    public static int total(int n, int[] v, int i) {
        if (n == 0) { return 1; }
        if (n < 0 || ( i == v.length && n > 0)) { return 0; }
        return total(n - v[i], v, i) + total(n, v, i + 1);
    }
    
    public static void main(String[] args) {
//        int arr[] = {1,5,10,20};
        int arr[] = {1,2,3};
        System.out.println(total(5, arr, 0));
    }
}
