package com.dhanunjay.arrays.subsequence;

import java.util.ArrayList;

public class PrintSubSequenceUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {3,1,2};
        print(0, arr, new ArrayList<>());
    }
    public static void print(int index, int[] arr, ArrayList<Integer> list){
        if(index >= arr.length){
            System.out.println(list);
            return;
        }
        list.add(arr[index]);
        print(index + 1, arr, list);
        list.remove(Integer.valueOf(arr[index]));
        print(index + 1, arr, list);
    }
}
