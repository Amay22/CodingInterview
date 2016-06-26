/*
    Input = Children's ratings are given in unsorted array
    Each child must have at least one candy. 
    Children with a higher rating get more candies than their neighbors.
    Find minimum candies to give.
    Time Complexity 0(n) and space complexity 0(n)

Note: Go from left to right to get higher neighbours
      Then go from right to left
*/

package ArrayInterview;

public class ChildrenCandy {

    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        //from left to right
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
            // if not ascending, assign 1
                candies[i] = 1;
            }
        }
        int result = candies[ratings.length - 1];
        //from right to left
        for (int i = ratings.length - 2; i >= 0; i--) {
            int cur = 1;
            if (ratings[i] > ratings[i + 1]) {
                cur = candies[i + 1] + 1;
            }
            result += Math.max(cur, candies[i]);
            candies[i] = cur;
        }
        return result;
    }
    public static void main(String[] args) {
        int arr[] = {100,7,10,110};
        System.out.println(candy(arr));
    }
}
