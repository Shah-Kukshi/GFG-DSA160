
//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class MajorityElementII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);

            if (ans.size() == 0) {
                System.out.println("[]");
            } else {
                for (int i : ans) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
        // Your code goes here.
        int n = nums.length;
        //Step 1: Find potential candidates
        int candidate1 = Integer.MIN_VALUE , candidate2 = Integer.MIN_VALUE;
        int count1 = 0 , count2 = 0;
        for(int num : nums){
            if(num ==  candidate1){
                count1++;
            }else if(num == candidate2){
                count2++;
            }else if(count1 == 0){
                candidate1 = num;
                count1 = 1;
            }else if(count2 == 0){
                candidate2 = num;
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }

        //Step : Verify Candidates
        count1 = 0;
        count2 = 0;
        for(int num : nums){
            if(num == candidate1){
                count1++;
            }else if(num ==  candidate2){
                count2++;
            }
        }

        //Step 3: Add valid candidates to the result
        List<Integer> result = new ArrayList<>();
        if(count1 > n/3)
        result.add(candidate1);
        if(count2 > n/3)
        result.add(candidate2);

        //Return result in sorted order
        Collections.sort(result);
        return result;
    }
}
