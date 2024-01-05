package com.dhanunjay.Arrays.Sorting;

import java.util.Arrays;
/*
    Time Complexity: O(N)
    Space Complexity: O(1)
 */

public class DutchNationalFlagAlgorithm {
    public static void main(String[] args) {
        int[] arr = {0,1,2,0,1,2,1,2,0,0,0,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high){
            if(arr[mid] == 0){
                swap(arr, low, mid);
                low++;
                mid++;
            }else if(arr[mid] == 1){
                mid++;
            }else{
               swap(arr, mid, high);
                high--;
            }
        }
    }
    public static void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
