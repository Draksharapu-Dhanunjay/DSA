package com.dhanunjay.arrays.subsequence;

import java.util.ArrayList;

public class PrintSubSequenceSumEqualsToK {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        subSequence(arr, 3);
    }
    public static void subSequence(int[] arr, int target){
        sequence(arr, new ArrayList<>(),  target, 0, 0);
    }
    public static void sequence(int[] arr, ArrayList<Integer> list, int target, int index ,int sum){
        if(index >= arr.length){
            if(sum == target){
                System.out.println(list);
            }
            return;
        }
        list.add(arr[index]);
        sequence(arr, list, target, index + 1, sum + arr[index]);
        list.remove(list.size() - 1);
        sequence(arr, list, target, index + 1, sum);
    }
}
