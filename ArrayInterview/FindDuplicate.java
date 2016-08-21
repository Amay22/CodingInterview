package ArrayInterview;


public class FindDuplicate {

    private static int findDuplicate(int[] nums) {
        int l=1,r=nums.length-1;
        while(l<r){
            int m=(l+r)/2;
            int c=0;

            for(int i: nums){
                if(i<=m){
                    c++;
                }
            }

            //if c < m,
            if(c>m){
                r=m;
            }else{
                l=m+1;
            }
        }

        return r;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,3,2,3,4,5,4,6}));
    }
}
