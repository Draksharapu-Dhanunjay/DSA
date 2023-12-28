package com.dhanunjay.Arrays.Sorting;

import java.util.Arrays;
import java.util.Scanner;
/*
    Note: Only applicable for array for 0 to n or 1 to n
    Time Complexity : O(n)
    space Complexity : O(1)
 */

public class CyclicSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Option 1)0 to N   2)1 to N :");
        int option = sc.nextInt();
        if(option > 2 || option < 1) {
            System.out.println("Enter a valid option!!!");
        }else{
            System.out.print("Enter size of array :");
            int n = sc.nextInt();
            int[] arr = new int[n];
            System.out.print("Enter elements of array :");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int i = 0;
            if(option == 1){
                while (i < n) {
                    if(arr[i] == i) {
                        i++;
                    }else {
                        int temp = arr[i];
                        arr[i] = arr[temp];
                        arr[temp] = temp;
                    }
                }
            }else {
                while (i < n) {
                    if(arr[i] - 1 == i) {
                        i++;
                    }else {
                        int temp = arr[i];
                        arr[i] = arr[temp - 1];
                        arr[temp - 1] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
