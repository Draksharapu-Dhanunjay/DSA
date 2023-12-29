package com.dhanunjay.Arrays.Basics;

import java.util.HashSet;

public class RemoveDuplicateInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3,3,4,4,5,5,7};
//        int k = removeDuplicate1(arr);
        int k = removeDuplicate2(arr);
        for(int i = 0; i < k; i++){
            System.out.print(arr[i] + " ");
        }
    }
    /*
        Time Complexity : O(N) + O(N) : O(N)
        Space Complexity : O(N)
     */
    public static int removeDuplicate1(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for (int j : arr) {
            set.add(j);
        }
        int i = 0;
        for(int x : set){
            arr[i++] = x;
        }
        return i;
    }
    /*
        Time Complexity : O(N)
        Space Complexity : O(1)
     */
    public static int removeDuplicate2(int[] arr){
        int i = 0, j = 0, n = arr.length;
        while (j < n){
            if(arr[i] != arr[j]){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            j++;
        }
        return i;
    }
}
