package com.dhanunjay.Arrays.Basics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum1(new int[] {2,6,5,8,11}, 10)));
        System.out.println(Arrays.toString(twoSum2(new int[] {2,6,5,8,11}, 6)));
        System.out.println(twoSum3(new int[] {2,6,5,8,11}, 14));
    }
    /*
        BruteForce Approach
        Time Complexity: O(N^2)
        Space Complexity: O(1)
     */
    public static int[] twoSum1(int[] arr, int target){
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] + arr[j] == target){
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
    /*
        Better Approach
        Time complexity: O(N)
        Space Complexity: O(N)
     */
    public static int[] twoSum2(int[] arr, int target){
        Map<Integer, Integer> hash = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int temp = target - arr[i];
            if(hash.containsKey(temp)){
                return new int[] {hash.get(temp),i};
            }else{
                hash.put(arr[i], i);
            }
        }
        return null;
    }
    /*
        Optimal Approach
        Time Complexity: O(NlogN) + O(N) : O(N + NlogN)
        Space Complexity: O(1)
        O(N) : if we consider the distorted array
     */
    public static String  twoSum3(int[] arr, int target){
        Arrays.sort(arr);
        int i = 0, j = arr.length - 1;
        while (i < j){
            if(arr[i] + arr[j] == target){
                return "yes";
            }
            if(arr[i] + arr[j] > target){
                j--;
            }else{
                i++;
            }
        }
        return "no";
    }
}
