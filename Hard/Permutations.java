/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hard;

import java.util.ArrayList;

/**
 *
 * @author Amay
 */
public class Permutations {

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
//start from an empty list
        result.add(new ArrayList<>());
        for (int i = 0; i < num.length; i++) {
//list of list in current iteration of the array num
            ArrayList<ArrayList<Integer>> current = new ArrayList<>();
            for (ArrayList<Integer> l : result) {
// # of locations to insert is largest index + 1
                for (int j = 0; j < l.size() + 1; j++) {
// + add num[i] to different locations
                    l.add(j, num[i]);
                    ArrayList<Integer> temp = new ArrayList<>(l);
                    current.add(temp);
//System.out.println(temp);
// - remove num[i] add
                    l.remove(j);
                }
            }
            result = new ArrayList<ArrayList<Integer>>(current);
        }
        return result;
    }
}
