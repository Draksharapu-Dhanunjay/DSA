package com.dhanunjay.arrays.subarray;
/*
    Time Complexity: O(N)
    Space Complexity: O(1)
 */

public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSum(arr));
    }

    public static int maxSum(int[] arr) {
        int max = Integer.MIN_VALUE, sum = 0;
        for(int num : arr){
            sum += num;
            if(sum > max){
                max = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}
