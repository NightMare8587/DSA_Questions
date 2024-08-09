package arrays;

import java.util.HashMap;
import java.util.HashSet;

public class DuplicateInteger {
    public static void main(String[] args) {
        int[] nums = {1,3,6,4,6,23,2};
        int arraySize = nums.length;

        boolean isDuplicateExists = betterSolutionFindingDuplicate(nums,arraySize);
        System.out.println("Array has duplicate: " + isDuplicateExists);
    }

    static boolean bruteForceApproach(int[] nums, int arraySize) {
        // if array size is 1 then no chance that duplicate exists
        if(arraySize == 1)
            return false;

        //runs a nested loop and check each element if there is any duplicate then we return true
        //else return false
        for(int i = 0; i<arraySize-1;i++) {
            for (int j = i+1; j < arraySize; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }


        // if above loop didn't return anything them surely no duplicate exists
        return false;
    }


    //better solution for finding duplicates in array
    static boolean betterSolutionFindingDuplicate(int[] nums, int arraySize) {
        HashSet<Integer> set = new HashSet<>();

        //loop through array and add each element in a set
        //if set already contains that element than return true
        //else add the element in the set
        for(int i=0; i<arraySize; i++) {
            if(set.contains(nums[i]))
                return true;
            else
                set.add(nums[i]);
        }

        //if above return didn't execute than return false i.e. duplicate isn't there in array
        return false;
    }
}
