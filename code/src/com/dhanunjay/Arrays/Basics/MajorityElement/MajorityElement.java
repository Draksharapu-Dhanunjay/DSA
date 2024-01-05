package com.dhanunjay.Arrays.Basics.MajorityElement;

import java.util.HashMap;
import java.util.Map;

// element appear > n / 2
public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2,2,3,3,1,2,2};
        int index = majority1(arr);
        System.out.println("Element appears most : "  + arr[index]);
        System.out.println("Element appears most : "  + majority2(arr));
    }
    /*
        BruteForce Approach
        Time Complexity: O(N^2)
        Space Complexity: O(1)
     */
    public static int majority1(int[] arr){
        int index = 0;
        for (int j : arr) {
            int count = 0;
            for (int k = 0; k < arr.length; k++) {
                if (j == arr[k]) {
                    count++;
                    index = k;
                }
            }
            if(count > arr.length /2){
                return index;
            }
        }
        return -1;
    }

    public static int majority2(int[] arr){
        Map<Integer, Integer> hash = new HashMap<>();
        for (int j : arr) {
            int value = hash.getOrDefault(j, 0);
            hash.put(j, value + 1);
        }
        for (Map.Entry<Integer, Integer> it : hash.entrySet()) {
            if (it.getValue() > (arr.length / 2)) {
                return it.getKey();
            }
        }
        return -1;
    }
}
