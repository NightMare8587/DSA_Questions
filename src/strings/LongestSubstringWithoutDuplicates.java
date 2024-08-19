package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Stack;

public class LongestSubstringWithoutDuplicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your input string: ");
        String input = reader.readLine();

        int length = input.length();

        int longestSubstringWithoutDuplicates = findLongestStringWithoutDuplicatesBetterSolution(input,length);

        System.out.println("Longest substring length without duplicates: " + longestSubstringWithoutDuplicates);

    }

    static int findLongestStringWithoutDuplicatesBruteForce(String input, int length) {
        int longest = 1;

        // if input is empty then return 0
        if(length == 0)
            return 0;

        // if input is 1 return 1
        if(length == 1)
            return longest;

        for(int i=0;i<length-1;i++) {
            // maintain a set which will contain visited non-duplicate characters
            HashSet<Character> set = new HashSet<>();
            // initially add the first char in set
            set.add(input.charAt(i));
            for(int j = i+1; j<length; j++) {
                if(set.contains(input.charAt(j))) {
                    // if we encounter already visited item in set then break and update the longest substring
                    longest = Math.max(set.size(),longest);
                    break;
                }

                // add the character in set
                set.add(input.charAt(j));
            }
            longest = Math.max(set.size(),longest);
        }

        return longest;
    }

    static int findLongestStringWithoutDuplicatesBetterSolution(String s, int length) {
        HashSet<Character>set=new HashSet<>();
        int maxLength=0;
        int left=0;
        for(int right=0;right<s.length();right++){

            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxLength=Math.max(maxLength,right-left+1);

            }else{
                while(s.charAt(left)!=s.charAt(right)){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(s.charAt(left));left++;
                set.add(s.charAt(right));
            }

        }
        return maxLength;
    }
}
