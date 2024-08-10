package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class ValidAnagram {
    public static void main(String[] args) throws IOException {
        // we can either use BufferedReader or we can use Scanner
        // BufferedReader is faster than scanner so in competitive programming we can use BufferedReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input first string: ");
        String str1 = reader.readLine();
        System.out.print("Input second string: ");
        String str2 = reader.readLine();

        boolean isValidAnagram = isValidAnagramCheck(str1.trim(),str2.trim());
        System.out.println("is String Anagram: " + isValidAnagram);
    }

    static boolean isValidAnagramCheck(String str1, String str2) {

        //store str1 in HashMap<Character, Occurrence of that char>
        HashMap<Character,Integer> map = new HashMap<>();

        // if both string lenght are not same then no way they are anagram
        if(str1.length() != str2.length())
            return false;

        //store first str in map
        for(int i=0; i<str1.length(); i++) {
            Character c = str1.charAt(i);

            if(map.containsKey(c)){
                int prevCount = map.get(c);
                prevCount++;
                map.put(c,prevCount);
            } else {
                map.put(c,1);
            }
        }

        // now check every char of str2 with map
        // if map doesn't contain this char then just return false
        // if map contains then reduce the occurrence int of map
        // if occurrence is 0 then remove element from map
        for(int i=0; i<str2.length();i++) {
            Character c = str2.charAt(i);

            if(map.containsKey(c)) {
                int prevIndex = map.get(c);
                prevIndex--;

                if(prevIndex == 0)
                    map.remove(c);
                else
                    map.put(c,prevIndex);
            } else return false;
        }

        // if map is empty then it is anagram as all characters were same
        // if map still has something then str1 and str2 are not anagrams
        return map.isEmpty();
    }
}
