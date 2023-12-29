package com.dhanunjay.Arrays.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
    Time Complexity: O(NlogN)
    Space Complexity: O(N)
 */

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter elements of array :");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        mergeSort(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int mid = (end - start)/2 + start;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }
    public static void merge(int[] arr, int start, int mid, int end){
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
}
