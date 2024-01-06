package com.dhanunjay.arrays.subarray;

public class PrintLongestSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int[] ans = maxSum(arr);
        System.out.print("[");
        for(int i = ans[0]; i <= ans[1]; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.print("]");
    }
    public static int[] maxSum(int[] arr) {
        int max = Integer.MIN_VALUE, sum = 0;
        int start = 0;
        int startIndex = -1, endIndex = -1;
        for(int i = 0; i < arr.length; i++){
            if(sum == 0){
                start = i;
            }
            sum += arr[i];
            if(sum > max){
                max = sum;
                startIndex = start;
                endIndex = i;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return new int[] {startIndex, endIndex};
    }
}
