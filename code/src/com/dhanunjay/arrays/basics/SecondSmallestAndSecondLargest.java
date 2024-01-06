package com.dhanunjay.arrays.basics;

import java.util.Arrays;
import java.util.Scanner;

public class SecondSmallestAndSecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter elements of array :");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(secondSmallestAndSecondLargest1(new int[] {2,1,0,0,-1,6,6})));
        System.out.println(Arrays.toString(secondSmallestAndSecondLargest2(arr)));
        System.out.println(Arrays.toString(secondSmallestAndSecondLargest3(arr)));
    }
    /*
        BruteForce Approach
        Time Complexity : O(NlogN) + O(N) + O(N) : O(N + NlogN)
        Space Complexity: O(1)
     */
    public static int[] secondSmallestAndSecondLargest1(int[] arr){
        Arrays.sort(arr);
        int min = arr[0] , max = arr[arr.length - 1], secMin = -1, secMax = -1;
        for(int i : arr){
            if(i != min){
                secMin = i;
                break;
            }
        }
        for(int i = arr.length - 1; i >= 0; i--){
            if(arr[i] != max){
                secMax = arr[i];
                break;
            }
        }
        return new int[] {secMin, secMax};
    }
    /*
        Better Approach
        Time Complexity : O(N) + O(N) : O(N)
        Space Complexity : O(1)
     */
    public static int[] secondSmallestAndSecondLargest2(int[] arr){
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE, secMin = Integer.MAX_VALUE, secMax = Integer.MIN_VALUE;
        for(int i: arr){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        for(int i: arr){
            if(i > min && i < secMin){
                secMin = i;
            }
            if(i < max && i > secMax){
                secMax = i;
            }
        }
        return new int[] {secMin, secMax};
    }
    /*
        Optimal Approach
        Time Complexity : O(N)
        Space Complexity : O(1)
     */
    public static int[] secondSmallestAndSecondLargest3(int[] arr){
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE, secMin = Integer.MAX_VALUE, secMax = Integer.MIN_VALUE;
        for(int i: arr){
            if(i < min){
                secMin = min;
                min = i;
            }else if(i > min && i < secMin){
                secMin = i;
            }
            if(i > max){
                secMax = max;
                max = i;
            }else if(i < max && i > secMax){
                secMax = i;
            }
        }
        return new int[] {secMin, secMax};
    }
}
