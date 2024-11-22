//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class ReverseAnArray {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String str[] = br.readLine().split(" ");
            int arr[] = new int[str.length];

            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            Solution obj = new Solution();

            obj.reverseArray(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public void reverseArray(int arr[]) {
        // code here
        //check if the array size is less then 2 , no need to reverse
        if(arr.length <= 1){
            return; //Single element array, nothing to reverse
        }
        
        //Two pointer approach for in-place reversal 
        int left = 0, right = arr.length -1;
        while(left < right){
            //Swap elemnts at 'left' and 'right'
            int temp =  arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            //Move pointers
            left++;
            right--;
        }
        
    }
}