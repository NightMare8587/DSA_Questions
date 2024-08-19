package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class PermutationStringExists {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter string 1: ");
        String input1 = reader.readLine();


        System.out.print("Enter string 2: ");
        String input2 = reader.readLine();

        boolean doesPermutationExists = checkIfPermutationOfStringExists(input1,input1.length(),input2,input2.length());
        System.out.println("Does permutation of string exists: " + doesPermutationExists);

    }
    static boolean checkIfPermutationOfStringExists(String input1, int length1, String input2, int length2) {
        boolean isExists = false;

        // if both string are same and length are same
        if((length1 == length2) && (Objects.equals(input1, input2)))
            return true;

        if(length1 < length2) {

        }

        return isExists;
    }
}
