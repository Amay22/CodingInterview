/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hard;

public class LRUPageSize {

// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int lruCountMiss(int max_cache_size, int[] pages) {
        // init
        int[] catche = new int[max_cache_size];
        int page_change = 0;
        for (int init = 0; init < catche.length; init++) {
            catche[init] = -1;
        }

        // start
        for (int i = 0; i < pages.length; i++) {
            if (into(pages[i], catche)) {
                page_change++;
            }
        }

        return page_change;
    }

    public static boolean into(int page, int[] catche) {
        for (int i = 0; i < catche.length; i++)// catch not full
        {
//	 System.out.println(page);

            if (catche[i] < 0) {
                catche[i] = page;
                return true;
            }
        }

        for (int j = 0; j < catche.length; j++)// don't change
        {
            if (catche[j] == page) {
                for (int m = j; m < catche.length - 1; m++) // move to end
                {
                    int temp = catche[m];
                    catche[m] = catche[m + 1];
                    catche[m + 1] = temp;
                }
                return false;
            }

        }

        // need change
        for (int k = 0; k < catche.length - 1; k++) // move to end
        {
            int temp = catche[k];
            catche[k] = catche[k + 1];
            catche[k + 1] = temp;
        }
        catche[catche.length - 1] = page;
        return true;

    }

// METHOD SIGNATURE ENDS
    public static void main(String[] args) {
	int []ca ={7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0};
//        int[] ca = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(lruCountMiss(3, ca));
    }

}
