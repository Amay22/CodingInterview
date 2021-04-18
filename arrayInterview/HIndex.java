package arrayInterview;

// citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total
// and each of them had received 3, 0, 6, 1, 5 citations respectively.
// Since the researcher has 3 papers with at least 3 citations each
// and the remaining two with no more than 3 citations each, his h-index is 3.

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int result = 0;
        for(int i=0; i<citations.length; i++){
            int smaller = Math.min(citations[i], citations.length-i);
            result = Math.max(result, smaller);
        }

        return result;
    }
}
