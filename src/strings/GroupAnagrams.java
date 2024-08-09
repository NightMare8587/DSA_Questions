package strings;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"c","act", "pots", "tops", "cat", "stop", "hat" ,"" , "", "c"};

        int arraySize = strs.length;

        List<List<String>> allGroupedAnagrams = returnGroupedAnagramsNotOptimized(strs, arraySize);

        System.out.println("All grouped anagrams list: " + allGroupedAnagrams);
    }

    static List<List<String>> returnGroupedAnagramsNotOptimized(String[] strs, int arraySize) {
        //maintain a arrayList to
        ArrayList<ArrayList<String>> parentList = new ArrayList<ArrayList<String>>();
        // contains all anagrams strings set
        HashSet<String> set = new HashSet<>();

        // if array size is 0 then return empty parent list
        if (arraySize == 0)
            return new ArrayList<>(parentList);

        // if arraySize is 1 then add first element and return parent list
        if (arraySize == 1) {
            ArrayList<String> tempList = new ArrayList<>();
            tempList.add(strs[0]);
            parentList.add(tempList);
            return new ArrayList<>(parentList);
        }

        for (int i = 0; i < arraySize; i++) {
            String currentStr = strs[i];
            ArrayList<String> tempList = new ArrayList<>();
            // if item is already added in HashSet then just continue
            if (set.contains(currentStr))
                continue;
            else {
                // if item is "" or single char then don't add it in set
                if(currentStr.length() != 1 && !currentStr.isEmpty())
                    set.add(currentStr);
            }

            tempList.add(currentStr);
            for (int j = i + 1; j < arraySize; j++) {
                String str2 = strs[j];

                boolean checkIfValidAnagram = isValidAnagramCheck(currentStr, str2);

                // if currentStr and str2 are both same i.e. cat and cat
                // then directly add without checking anagram
                if(currentStr.equals(str2)) {
                    tempList.add(str2);
                    set.add(str2);
                }
                //check for anagram and check if added in set or not
                else if (checkIfValidAnagram && !set.contains(str2)) {
                    tempList.add(str2);
                    set.add(str2);
                }
            }
            // finally add the list in parent List
            parentList.add(tempList);
        }
        // return the parent list
        return new ArrayList<>(parentList);
    }

    static boolean isValidAnagramCheck(String str1, String str2) {

        //store str1 in HashMap<Character, Occurrence of that char>
        HashMap<Character, Integer> map = new HashMap<>();

        // if both string lenght are not same then no way they are anagram
        if (str1.length() != str2.length())
            return false;

        //store first str in map
        for (int i = 0; i < str1.length(); i++) {
            Character c = str1.charAt(i);

            if (map.containsKey(c)) {
                int prevCount = map.get(c);
                prevCount++;
                map.put(c, prevCount);
            } else {
                map.put(c, 1);
            }
        }

        // now check every char of str2 with map
        // if map doesn't contain this char then just return false
        // if map contains then reduce the occurrence int of map
        // if occurrence is 0 then remove element from map
        for (int i = 0; i < str2.length(); i++) {
            Character c = str2.charAt(i);

            if (map.containsKey(c)) {
                int prevIndex = map.get(c);
                prevIndex--;

                if (prevIndex == 0)
                    map.remove(c);
                else
                    map.put(c, prevIndex);
            } else return false;
        }

        // if map is empty then it is anagram as all characters were same
        // if map still has something then str1 and str2 are not anagrams
        return map.isEmpty();
    }
}
