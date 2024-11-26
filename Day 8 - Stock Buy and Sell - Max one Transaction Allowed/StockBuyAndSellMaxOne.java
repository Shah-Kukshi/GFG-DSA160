//{ Driver Code Starts
// Initial Template for Java
//Max one transation allowed

import java.io.*;
import java.lang.*;
import java.util.*;

class StockBuyAndSellMaxOne {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int prices[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                prices[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int res = obj.maximumProfit(prices);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maximumProfit(int prices[]) {
        // Code here
        
        //edge case: if prices array is empty or has only one element , return 0
        if(prices == null || prices.length <-1){
            return 0;
        }
        
        //Initialize the min pric
        int minPrice = prices[0];
        int maxProfit = 0;
        
        //Iteration
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            else{
                int potentialProfit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit , potentialProfit);
            }
        }
        
        return maxProfit;
    }
}