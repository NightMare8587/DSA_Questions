package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] input = {-1,0,1,2,-1,4};
        int arraySize = input.length;

        List<List<Integer>> groupedThreeSumList = checkAndFindThreeSumIfExistsBruteForce(input,arraySize);

        System.out.println("Printing is grouped three sum exists: " + groupedThreeSumList);
    }

    static List<List<Integer>> checkAndFindThreeSumIfExistsBruteForce(int[] input, int arraySize) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for(int i=0;i<arraySize-2;i++) {
            for(int j = i+1; j<arraySize-1; j++) {
                for(int k = j+1; k<arraySize; k++) {
                    if(input[i] + input[j] + input[k] == 0) {
                        ArrayList<Integer> tempList = new ArrayList<>();
                        tempList.add(input[i]);
                        tempList.add(input[j]);
                        tempList.add(input[k]);
                        Collections.sort(tempList);
                        if(set.contains(tempList))
                            continue;
                        else
                            set.add(tempList);
                        list.add(tempList);
                    }
                }
            }
        }

        return new ArrayList<>(list);
    }
}
