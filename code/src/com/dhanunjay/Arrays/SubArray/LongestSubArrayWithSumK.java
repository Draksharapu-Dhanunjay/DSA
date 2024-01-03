package com.dhanunjay.Arrays.SubArray;

import java.util.HashMap;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {1,2,3,0,0,0,1,1,1,1,4,2,3};
        System.out.println(subArray1(arr, 6));
        System.out.println(subArray2(arr, 6));
        System.out.println(subArray3(arr, 6));
    }
    /*
        BruteForce Approach
        Time Complexity: O(n * n)
        Space Complexity: O(1)
     */
    public static int subArray1(int[] arr, int k){
        int len = -1;
        for(int i = 0; i < arr.length; i++){
            int sum  = 0;
            for(int j = i; j < arr.length; j++){
                sum += arr[j];
                if(sum == k){
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;
    }
    /*
        Better Approach / optimal for array containing negative values
        Time Complexity: O(n)
        Space Complexity: O(n)
     */
    public static int subArray2(int[] arr, int k){
        int len = -1, sum = 0;
        HashMap<Integer, Integer> hash = new HashMap<> ();
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            int rem = sum - k;
            if(hash.containsKey(rem)){
                len = Math.max(len, i - hash.get(rem));
            }
            if(sum == k){
                len = Math.max(len, i + 1);
            }
            if(!hash.containsKey(sum)){
                hash.put(sum, i);
            }
        }
        return len;
    }
    /*
        Optimal Approach:
        Time Complexity: O(n)
        Space Complexity: O(1)
     */
    public static int subArray3(int[] arr, int k){
        int len = -1, sum = 0, i = 0, j = 0, n = arr.length;
        while (j < n){
            if(sum == k){
                len = Math.max(len, j - i + 1);
                j++;
                sum += arr[j];
            }else if(sum > k){
                sum -= arr[i];
                i++;
            }else{
                sum += arr[j];
                j++;
            }
        }
        return len;
    }
}
