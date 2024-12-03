//{ Driver Code Starts
import java.io.*;
import java.util.*;

class MaxCircularSubarraySum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().circularSubarraySum(arr));
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    //funciton to find maximum subarray sum in a normal array using kadane's algorithm 
    private int kadane(int arr[] , int n){
        int maxSum = arr[0];
        int currentSum = arr[0];
        
        for(int i = 1; i<n; i++){
            currentSum = Math.max(arr[i] , currentSum + arr[i]);
            maxSum = Math.max(maxSum , currentSum);
            
        }
        return maxSum;
    }
    
    //fucntion to find the minimu subarray sum in a normal array using a similar kadane's algorithm
    private int kadaneMin(int arr[] , int n){
        int minSum = arr[0];
        int currentSum = arr[0];
        
        for(int i = 1; i<n; i++){
            currentSum = Math.min(arr[i] , currentSum + arr[i]);
            minSum = Math.min(minSum , currentSum);
            
        }
        return minSum;
    }
    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int arr[]) {

        int n = arr.length;
        int max_sum_normal = kadane(arr , n);
         
        int min_sum_normal = kadaneMin(arr , n);
         
        int total_sum = 0;
        for(int num : arr){
            total_sum += num;
        }
         
        if(total_sum == min_sum_normal){
            return max_sum_normal;         
        }
        
        return Math.max(max_sum_normal, total_sum - min_sum_normal);
    }
    
}
