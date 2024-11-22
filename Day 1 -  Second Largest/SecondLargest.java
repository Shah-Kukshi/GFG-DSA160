//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class SecondLargest {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
         int n = arr.length;
        
        // Edge case: If the array has fewer than 2 distinct elements
        if (n < 2) return -1;
        
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        // Traverse the array to find the largest and second largest elements
        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;  // Update second largest
                largest = num;            // Update largest
            } else if (num > secondLargest && num < largest) {
                secondLargest = num;      // Update second largest
            }
        }
        
        // If secondLargest is still Integer.MIN_VALUE, no second largest element exists
        if (secondLargest == Integer.MIN_VALUE) {
            return -1;
        }
        
        return secondLargest;
    }
}