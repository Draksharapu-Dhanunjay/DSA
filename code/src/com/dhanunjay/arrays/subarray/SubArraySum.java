package com.dhanunjay.arrays.subarray;

public class SubArraySum {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSubArraySum(arr));
    }
    /*
        BruteForce Approach
        Time Complexity: O(N^2)
        Space Complexity: O(1)
     */
    public static int maxSubArraySum(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            int sum = 0;
            for(int j = i; j < arr.length; j++){
                sum += arr[j];
                max = Math.max(sum, max);
            }
        }
        return max;
    }
}
