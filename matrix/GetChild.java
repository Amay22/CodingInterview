package matrix;


import java.util.Scanner;

public class GetChild {

    public static void max_subjets() {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int mat[][] = new int[n][m];
        sc.nextLine();
        for (int i = 0; i < n; ++i) {
            String s = sc.nextLine();
            for (int j = 0; j < m; ++j) {
                mat[i][j] = Integer.parseInt(""+s.charAt(j));
            }
        }
        int max = 0;
        for (int i = 0; i < n; ++i) {
            for (int k = i + 1; k < n; ++k) {
                int count = 0;
                for (int j = 0; j < m; ++j) {
                    if (mat[i][j] == 1 || mat[k][j] == 1) {
                        count++;
                    }
                }
                if(max < count){max=count;}
            }
        }
        int max_groups = 0;
        for (int i = 0; i < n; ++i) {
            for (int k = i + 1; k < n; ++k) {
                int count = 0;
                for (int j = 0; j < m; ++j) {
                    if (mat[i][j] == 1 || mat[k][j] == 1) {
                        count++;
                    }
                }
                if(count == max){max_groups++;}
            }
        }
        System.out.println(max);
        System.out.println(max_groups);
    }

    public static void main(String[] args) {
        max_subjets();
    }
}
