package com.dhanunjay.arrays.searching;

import java.util.Scanner;
/*
    Time Complexity : O(NlogN) if array is sorted
                       O(NlogN) + O(NlogN) : O(2NlogN) : O(NlogN) if array is unsorted
    Space Complexity : O(1)
 */

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter elements of array :");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter element to find:");
        int target = sc.nextInt();
//        Arrays.sort(arr);
        System.out.println("Index of "+ target +" :"+ binarySearch(arr, target));
    }
    static int binarySearch(int[] arr, int target){
        int start = 0, end = arr.length - 1;
        while (start <= end){
            int mid = (end - start)/2 + start;
            if(arr[mid] == target){
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
