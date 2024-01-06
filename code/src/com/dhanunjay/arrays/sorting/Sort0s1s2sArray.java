package com.dhanunjay.arrays.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class Sort0s1s2sArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort1(new int[] {0,1,2,0,1,2,1,2,0,0,0,1})));
        System.out.println(Arrays.toString(sort2(new int[] {0,1,2,0,1,2,1,2,0,0,0,1})));
    }
    /*
        BruteForce Approach
        Time Complexity: O(NlogN)
        Space Complexity: O(N) -> merge sort
        Space Complexity: O(1) -> QuickSort
     */
    public static int[] sort1(int[] arr){
        mergerSort(arr, 0, arr.length - 1);
        return arr;
    }
    public static void mergerSort(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int mid = (end - start)/2 + start;
        mergerSort(arr, start, mid);
        mergerSort(arr, mid + 1, end);
        merger(arr, start, mid, end);
    }
    public static void merger(int[] arr, int start, int mid, int end){
        ArrayList<Integer> list = new ArrayList<>();
        int low = start, high = mid + 1;
        while (low <= mid && high <= end){
            if(arr[low] <= arr[high]){
                list.add(arr[low]);
                low++;
            }else{
                list.add(arr[high]);
                high++;
            }
        }
        while (low <= mid){
            list.add(arr[low]);
            low++;
        }
        while (high <= end){
            list.add(arr[high]);
            high++;
        }
        for(int i = start; i <= end; i++){
            arr[i] = list.get(i - start);
        }
    }
    /*
        Better Approach
        Time Complexity: O(N) + O(N) : O(2N) : O(N)
        Space Complexity: O(1)
     */
    public static int[] sort2(int[] arr){
        int countZero = 0, countOne = 0;
        for(int num: arr){
            if(num == 0){
                countZero++;
            }else if(num == 1) {
                countOne++;
            }
        }
        int i = 0;
        while (i < countZero){
            arr[i] = 0;
            i++;
        }
        while (i < countZero + countOne){
            arr[i] = 1;
            i++;
        }
        while (i < arr.length){
            arr[i] = 2;
            i++;
        }
        return arr;
    }
}
