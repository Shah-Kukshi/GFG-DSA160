//{ Driver Code Starts
// Initial template for JAVA

import java.util.Scanner;

class ImplementAtoi {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String str = sc.nextLine();

            Solution obj = new Solution();
            int num = obj.myAtoi(str);
            System.out.println(num);
            System.out.println("~");
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public int myAtoi(String s) {
        // Your code here
         // Define constants for 32-bit integer limits
        int INT_MAX = Integer.MAX_VALUE;
        int INT_MIN = Integer.MIN_VALUE;
        
        // Step 1: Remove leading whitespaces
        s = s.trim();
        
        // Step 2: Handle empty string after trimming
        if (s.isEmpty()) {
            return 0;
        }   
        
        // Step 3: Initialize variables
        int sign = 1;  // Default to positive
        int result = 0;
        int i = 0;
        
        // Step 4: Handle sign (+ or -)
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        
        // Step 5: Convert digits to integer
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';  // Convert character to digit
            // Check for overflow or underflow before updating result
            if (result > (INT_MAX - digit) / 10) {
                return sign == 1 ? INT_MAX : INT_MIN;  // Overflow or underflow
            }
            result = result * 10 + digit;
            i++;
        }
        
        // Step 6: Apply the sign and return result
        return result * sign;
    }
}