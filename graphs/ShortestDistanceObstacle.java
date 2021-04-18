package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Graphs.QItem for current location and distance
// from source location
class QItem {
    int row;
    int col;
    int dist;
    QItem(int x, int y, int w){
        row = x;
        col = y;
        dist = w;
    }
}

public class ShortestDistanceObstacle
{

    int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot)
    {
        QItem source = new QItem(0, 0, 0);

        // To keep track of visited QItems. Marking
        // blocked cells as visited.
        boolean[][] visited = new boolean[numRows][ numColumns];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (lot.get(i).get(j) == '0')
                    visited[i][j] = true;
                else
                    visited[i][j] = false;

                // Finding source
                if (lot.get(i).get(j) == 's') {
                    source.row = i;
                    source.col = j;
                }
            }
        }

        // applying BFS on matrix cells starting from source
        Queue<QItem> q = new LinkedList<>();

        q.add(source);

        visited[source.row][source.col] = true;
        while (!q.isEmpty()) {
            QItem p = q.peek();
            q.remove();

            if (lot.get(p.row).get(p.col)  == 'd') {
                return p.dist;
            }

            // moving up
            if (p.row - 1 >= 0 && visited[p.row - 1][p.col] == false) {

                q.add(new QItem(p.row - 1, p.col, p.dist + 1));
                visited[p.row - 1][p.col] = true;
            }

            // moving down
            if (p.row + 1 < numRows && visited[p.row + 1][p.col] == false) {
                q.add(new QItem(p.row + 1, p.col, p.dist + 1));
                visited[p.row + 1][p.col] = true;
            }

            // moving left
            if (p.col - 1 >= 0 && visited[p.row][p.col - 1] == false) {
                q.add(new QItem(p.row, p.col - 1, p.dist + 1));
                visited[p.row][p.col - 1] = true;
            }

            // moving right
            if (p.col + 1 < numColumns && visited[p.row][p.col + 1] == false) {
                q.add(new QItem(p.row, p.col + 1, p.dist + 1));
                visited[p.row][p.col + 1] = true;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {

        List<List<Integer>> lot = new ArrayList<>();
        //        lot.add
        //        char grid[ N][M] ={
        //        {
        //            '0', '*', '0', 's'
        //        },
        //        {
        //            '*', '0', '*', '*'
        //        },
        //        {
        //            '0', '*', '*', '*'
        //        },
        //        {
        //            'd', '*', '*', '*'
        //        }
        //    } ;

        //        System.out.println(minDistance(grid));
    }
}


//
//    // IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
//    // SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//    // DEFINE ANY CLASS AND METHOD NEEDED
//    import java.util.List;
//// CLASS BEGINS, THIS CLASS IS REQUIRED
//public class Solution
//{
//
//    // METHOD SIGNATURE ENDS
//}
