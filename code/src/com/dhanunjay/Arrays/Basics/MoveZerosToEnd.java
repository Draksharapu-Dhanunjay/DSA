package com.dhanunjay.Arrays.Basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter array elements :");
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
//        moveZeros1(arr);
        moveZeros2(arr);
        System.out.println(Arrays.toString(arr));
    }
    /*
        BruteForce Approach:
        n : arr.length and all are unique elements without zero
        Time Complexity: O(n) + O(n) : O(2 * n) : O(n)
        Space Complexity: O(n)
     */
    public static void moveZeros1(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        for (int j : arr) {
            if (j != 0) {
                list.add(j);
            }
        }
        for(int i = 0; i < list.size(); i++){
            arr[i] = list.get(i);
        }
        for(int i = list.size(); i < arr.length; i++){
            arr[i] = 0;
        }
    }
    /*
        Optimal Approach:
        n : arr.length
        Time Complexity: O(n)
        Space Complexity: O(1)
     */
    public static void moveZeros2(int[] arr){
        int i = 0, j = 0, n = arr.length;
        while (j < n){
            if(arr[j] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
            j++;
        }
    }
}
