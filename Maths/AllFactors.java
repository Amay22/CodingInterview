package Maths;

public class AllFactors {

    public static int[] getAllFactors(int num) {
        int ans[] = new int[num/2];
        int index = 0;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                ans[index++] = i;
                ans[index++] = num/i;
                num /= i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int num = 10;
        int result[] = getAllFactors(num);
        for(int i: result){
            if(i==0){break;}
            System.out.print(i+" ,");
        }
    }
}
