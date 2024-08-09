package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopK_Elements {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,3};
        int arraySize = nums.length;

        int target = 2;
        int[] topK_ElementsArray = getK_ElementsFromInput(nums,arraySize,target);
        System.out.println("TopK Elements in given array is: " + Arrays.toString(topK_ElementsArray));
    }

    static int[] getK_ElementsFromInput(int[] items, int arraySize, int target) {
        int[] result = new int[2];
        if(arraySize == 1) {
            result[0] = items[0];
            result[1] = items[0];

            return result;
        }

        HashMap<Integer,Integer> map = new HashMap<>();


        for(int i=0; i<arraySize-1; i++) {
            int occurence = 1;

            for(int j = i+1; j<arraySize; j++) {
                if(items[i] == items[j])
                    occurence++;
            }

            if(map.size() <= target) {
                map.put(items[i],occurence);
            } else {
                for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                    if(occurence > entry.getValue()) {
                        entry.setValue(occurence);
                        break;
                    }
                }
            }
        }
        int count = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(count > 1)
                break;
            result[count] = entry.getValue();
            count++;
        }

        return result;
    }
}
