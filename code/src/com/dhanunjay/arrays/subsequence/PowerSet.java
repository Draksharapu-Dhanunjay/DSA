package com.dhanunjay.arrays.subsequence;

import java.util.ArrayList;

public class PowerSet {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 2};
        print(arr);
    }
    public static void print(int[] arr){
        for(int i = 0; i < Math.pow(2, arr.length); i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 0; j < arr.length; j++){
                if((i & (1 << j)) != 0){
                    list.add(arr[j]);
                }
            }
            System.out.println(list);
        }
    }
}
