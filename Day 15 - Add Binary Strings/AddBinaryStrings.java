//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class AddBinaryStrings {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a, b;
            a = sc.next();
            b = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String addBinary(String s1, String s2) {
        StringBuilder result = new StringBuilder();
        
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        
        int carry = 0; 
        
        // Perform the binary addition
        while (i >= 0 || j >= 0 || carry != 0) {
            int bit1 = i >= 0 ? s1.charAt(i) - '0' : 0;  // Get bit from s1 or 0 if out of bounds
            int bit2 = j >= 0 ? s2.charAt(j) - '0' : 0;  // Get bit from s2 or 0 if out of bounds
            
            int sum = bit1 + bit2 + carry;
            carry = sum / 2;  // Calculate carry for next iteration
            result.append(sum % 2);  // Append the sum bit to result
            
            i--;
            j--;
        }
        
        // Reverse the result to get the final binary string
        result.reverse();
        
        // Remove leading zeros (if any)
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);  // Remove the leading zero
        }
        
        // Return the final result
        return result.toString();
    }
}
