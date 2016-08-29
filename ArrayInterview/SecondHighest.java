package ArrayInterview;

/**
 * Created by amay on 8/29/16.
 */
public class SecondHighest {
    public static int second_highest(int arr[]){
        int highest = Integer.MIN_VALUE+1;
        int sec_highest = Integer.MIN_VALUE;
        for(int i : arr) //b is array of integers
        {
            if(i>highest)
            {
                sec_highest = highest; //make current highest to second highest
                highest = i; //make current value to highest
            }
            else if(i>sec_highest && i != highest)
            {
                sec_highest = i;
            }
        }
        return sec_highest;
    }
    public static void main(String[] args) {
        int nums[] = {3, 30, 34, 5, 9,955};
        System.out.println(second_highest(nums));
    }
}
