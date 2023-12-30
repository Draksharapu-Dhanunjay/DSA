package com.dhanunjay.Arrays.Basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RotateAnArrayByK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 1)Right Rotate 2)Left Rotate :");
        int option = sc.nextInt();
        if(option == 1 || option == 2){
            System.out.print("Enter size of array :");
            int n = sc.nextInt();
            int[] arr = new int[n];
            System.out.print("Enter array elements :");
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            System.out.print("Enter number of rotations :");
            int k = sc.nextInt();
            if(option == 1){
                rightRotate1(arr, k);
                rightRotate2(arr, k);
            }else{
                leftRotate1(arr, k);
                leftRotate2(arr, k);
            }
            System.out.println(Arrays.toString(arr));
        }else{
            System.out.println("Please Enter a valid Input!!!");
        }
    }
    /*
        BruteForce Approach
        Time Complexity: O(n - k) + O(k) + O(k) : O(n + k)
        Space Complexity: O(k)
     */
    public static void rightRotate1(int[] arr, int k){
        // 1 2 3 4 5 -> 4 5 1 2 3
        int n = arr.length;
        k = k % n;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n - k; i++){
            list.add(arr[i]);
        }
        for(int i = 0; i < k; i++){
            arr[i] = arr[n - k + i];
        }
        for(int i = k; i < n; i++){
            arr[i] = list.get(i - k);
        }
    }
    public static void leftRotate1(int[] arr, int k){
        int n = arr.length;
        k = k % n;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < k; i++){
            list.add(arr[i]);
        }
        for(int i = k; i < n; i++){
            arr[i - k] = arr[i];
        }
        int j = 0;
         for(int i = n - k; i < n; i++){
            arr[i] = list.get(j++);
        }
    }

    /*
        Optimal Approach
        Time Complexity: O(k) + O(n-k) + O(n) : O(2 * n) : O(n)
        Space Complexity: O(1)
     */
    public static void leftRotate2(int[] arr, int k){
        int n = arr.length;
        k = k % n;
        reverse(arr, 0, k);
        reverse(arr, k, n);
        reverse(arr, 0, n);
    }
    public static void rightRotate2(int[] arr, int k){
        int n = arr.length;
        k = k % n;
        reverse(arr, 0, k);
        reverse(arr, k, n);
        reverse(arr, 0, n);
    }
    public static void reverse(int[] arr, int start, int end){
        end--;
        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
