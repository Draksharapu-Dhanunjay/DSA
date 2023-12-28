package com.dhanunjay.Arrays.Sorting;

import java.util.Arrays;
import java.util.Scanner;

/*
    Time Complexity : O(N^2)
    Space Complexity : O(1)
 */

public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter elements of array :");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            int maxIndex = 0;
            for(int j = 0; j < n - i; j++){
                if(arr[maxIndex] < arr[j]){
                    maxIndex = j;
                }
            }
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
