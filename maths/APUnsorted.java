
package maths;

public class APUnsorted {
    public static boolean isAPorNOt(int nums[]) {
        int highest =Integer.MIN_VALUE, min = Integer.MAX_VALUE,  sum = 0;
        for(int num: nums){
            sum+=num;
            if(highest < num){
                highest =num;
            }
             if(min > num){
                min =num;
            }
        }

        int expected_sum = (min+highest)*nums.length/2;
        return sum == expected_sum;
    }

    public static void main(String[] args) {
        int num[] = {-1,5,3,11,13,1,7,9};
        System.out.println(isAPorNOt(num));
        int num2[]= {5,3,1,11,7,8};
        System.out.println(isAPorNOt(num2));
    }
}
