package com.dhanunjay.Arrays.Searching;

import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter elements of array :");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter Target :");
        int target = sc.nextInt();
        boolean exist = false;
        for(int num : arr){
            if(num == target){
                exist = true;
                break;
            }
        }
        if(exist){
            System.out.println("Number Exist!");
        }else{
            System.out.println("Number Not Exist!");
        }
    }
}
