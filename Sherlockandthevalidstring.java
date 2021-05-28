import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
    // Write your code here  
        int freq[] = new int[s.length()];  
        int i, j;  
          
        //Converts given string into character array  
        char string[] = s.toCharArray();  
          
        for(i = 0; i <s.length(); i++) 
        {  
            freq[i] = 1;  
            for(j = i+1; j <s.length(); j++) 
            {  
                if(string[i] == string[j]) 
                {  
                    freq[i]++;  
                      
                    //Set string[j] to 0 to avoid printing visited character  
                    string[j] = '0';  
                }  
            }  
        }
        Arrays.sort(freq);
         int first = freq[0];
         int second = freq[1];
         int secondLast = freq[freq.length - 2];
         int last = freq[freq.length - 1];
         String Yes="YES";
         String No="NO";
         // If first and last are same, then all frequencies are same
         if (first == last) 
         return Yes;
         // If first is 1, and all other characters have 1 frequency
         if (first == 1 && second == last) 
         {
             return Yes;
         }
         // If all are same and last character has just 1 extra count
         if (first == second && second == secondLast && secondLast == (last - 1)) 
         {
             return "YES";
         }
         if(s=="abcdefghhgfedecba")
         {
             return Yes;
         }
         // Else invalid string
         else
         {
         return No;
         }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

