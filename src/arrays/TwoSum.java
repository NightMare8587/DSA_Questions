package arrays;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {1,4,6,3,7,9,4,3};
        int arraySize = nums.length;

        int target = 9;

        int[] isTwoSumExists = checkAndReturnIfTwoSumExistsOptimized(nums,arraySize,target);
        System.out.println("Two sum values: " + isTwoSumExists[0] + " And " + isTwoSumExists[1]);
    }

    // Bruteforce solution
    static int[] checkAndReturnIfTwoSumExistsBruteForce(int[] nums, int arraySize,int target) {
        // intialise an array with size of 2
        int[] array = new int[2];
        for(int i=0; i<arraySize-1; i++) {
            for(int j=i+1; j<arraySize; j++) {
                // run nested loop and check if two values sum exists in array
                // if exists then update the array
                if(nums[i] + nums[j] == target) {
                    array[0] = i;
                    array[1] = j;
                    return array;
                }
            }
        }
        return array;
    }

    static int[] checkAndReturnIfTwoSumExistsOptimized(int[] nums, int arraySize, int target) {
        int[] array = new int[2];
        // maintain a hashMap of number and index of that number
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<arraySize; i++) {
            // if map contains (target - nums[i]) i.e. two sum exists
            // return the index of both values
            if(map.containsKey(target - nums[i])) {
                array[1] = i;
                array[0] = map.get(target - nums[i]);

                return array;
            } else {
                // add that value in map with ith Index
                map.put(nums[i],i);
            }
        }

        // return the array
        return array;
    }
}
