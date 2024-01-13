package com.dhanunjay.arrays.subsequence;

import java.util.ArrayList;

public class PrintAnyOneSubSequenceSumEqualsToK {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        System.out.println(subSequence(arr, new ArrayList<>(), 0, 6, 0));
        System.out.println(subSequenceCount(arr, new ArrayList<>(), 0, 5, 0));
    }
    public static boolean subSequence(int[] arr, ArrayList<Integer> list, int index, int target, int sum){
        if(index >= arr.length){
            if(sum == target){
                System.out.println(list);
                return true;
            }
            return false;
        }
        list.add(arr[index]);
        if(subSequence(arr, list, index + 1, target, sum + arr[index])){
            return true;
        }
        list.remove(list.size() - 1);
        return subSequence(arr, list, index + 1, target, sum);
    }
    public static int subSequenceCount(int[] arr, ArrayList<Integer> list, int index, int target, int sum){
        if(index >= arr.length){
            if(sum == target){
                return 1;
            }
            return 0;
        }
        list.add(arr[index]);
        int left = subSequenceCount(arr, list, index + 1, target, sum + arr[index]);
        list.remove(list.size() - 1);
        int right = subSequenceCount(arr, list, index + 1, target, sum);
        return left + right;
    }
}
