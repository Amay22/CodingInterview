package Recursion;


public class FloodFill {
    public static boolean will_fit(int height, int width, int x , int y){
        return x < height && x >= 0 && y < width && y >=0;
    }
    
    public static int[][] result(int height, int width, int seed){
        int answer[][] = new int[height][width];
        int filled = 0;
        int x = 0 , y = 0;
        String digit = ""+height;
        int x_len = digit.length();
        digit = ""+height;
        int y_len = digit.length();
        while (filled != seed){
            x = (int)(Math.random()*10*x_len);
            y = (int)(Math.random()*10*y_len);
            if(will_fit( height,  width,  x ,  y) && answer[x][y] != 1){
                answer[x][y] = 1;
                filled++;
            }
        }
        return answer;
    }
    
    public static int[][] flood_fill(int x , int  y,int ans[][]){        
        if(!will_fit(ans.length, ans[0].length,  x , y) || ans[x][y] != 0){return ans;}
        ans[x][y] = 2;
        System.out.println("-------------------LOOOP START----------------");
        for (int[] an : ans) {
            for (int j = 0; j < an.length; j++) {
                System.out.print(an[j]);
            }
            System.out.println("");
        }
        System.out.println("-------------------LOOOP END----------------");
        flood_fill( x+1 ,y,ans);
        flood_fill( x-1 ,y,ans);
        flood_fill( x ,y+1,ans);
        flood_fill( x ,y-1,ans);
        return ans;
    }
    public static void main(String[] args) {
        int ans[][] = result(10, 10, 8);
         ans = flood_fill(4,4,ans);
        for (int[] an : ans) {
            for (int j = 0; j < an.length; j++) {
                System.out.print(an[j]);
            }
            System.out.println("");
        }
    }
}
