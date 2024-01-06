package com.dhanunjay.arrays.basics;

public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,0,1,0,1,0};
        int count = 0, len = 0;
        for (int j : arr) {
            if (j == 1) {
                count++;
                len = Math.max(len, count);
            } else {
                count = 0;
            }
        }
        System.out.println("Number of Consecutive One's" + len);
    }
}
