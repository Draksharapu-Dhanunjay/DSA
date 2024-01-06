package com.dhanunjay.arrays.basics;

import java.util.Arrays;
import java.util.Scanner;

public class SmallestAndLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter elements of array :");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(smallestAndLargest1(arr)));
        System.out.println(Arrays.toString(smallestAndLargest2(arr)));
    }
    /*
        BruteForce Approach:
        Time Complexity: O(NlogN)
        Space Complexity: O(1)
     */
    public static int[] smallestAndLargest1(int[] arr){
        Arrays.sort(arr);
        return new int[] {arr[0], arr[arr.length - 1]};
    }
    /*
        Optimal Approach:
        Time Complexity: O(N)
        Space Complexity: O(1)
     */
    public static int[] smallestAndLargest2(int[] arr){
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i : arr){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        return new int[] {min, max};
    }
}
