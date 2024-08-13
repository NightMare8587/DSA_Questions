package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValidPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a string: ");
        String input = reader.readLine();

        System.out.println("Checking if palindrome or not...");
        input = formatInputStringForPalindromeCheck(input);
        int length = input.length();
        boolean isStringPalindrome = checkIfStringIsValidPalindromeOrNot(input,length);

        System.out.println("Is Input String Palindrome: " + isStringPalindrome);
    }

    private static String formatInputStringForPalindromeCheck(String input) {
        String str = input;
        str = str.toLowerCase();
        str = str.replaceAll(" ","");
        str = str.trim();
        str = str.replaceAll("[^a-zA-Z0-9]","");
        return str;
    }

    static boolean checkIfStringIsValidPalindromeOrNot(String input, int length) {
        int startIndex = 0;
        int endIndex = length-1;

        while(startIndex < endIndex) {

            if(input.charAt(startIndex) != input.charAt(endIndex)) {
                System.out.println("Start value: " + input.charAt(startIndex));
                System.out.println("End value: " + input.charAt(endIndex));
                return false;
            }

            startIndex++;
            endIndex--;
        }

        return true;
    }
}
