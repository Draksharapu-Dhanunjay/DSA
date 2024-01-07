package com.dhanunjay.arrays.basics;

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeArrayElements {
    public static void main(String[] args) {
        int[] arr = {3, 1, -2, -5, 2, -4};
        System.out.println(Arrays.toString(rearrangeArray1(arr)));
        System.out.println(Arrays.toString(rearrangeArray2(arr)));
        System.out.println(Arrays.toString(rearrangeArray3(new int [] {3, 1, -2, -5, 2, -4, 1, -2, -5})));
    }
    /*
        BruteForce Approach
        Time Complexity: O(N) + O(N) : O(2N)
        Space Complexity: O(N)
     */
    public static int[] rearrangeArray1(int[] nums) {
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        for(int num : nums){
            if(num >= 0){
                positive.add(num);
            }else{
                negative.add(num);
            }
        }
        for(int i = 0; i < positive.size(); i++){
            nums[2 * i] = positive.get(i);
            nums[2 * i + 1] = negative.get(i);
        }
        return nums;
    }
    /*
        Optimal
        Time Complexity: O(N)
        Space Complexity: O(N)
     */
    public static int[] rearrangeArray2(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0, j = 1;
        for(int num : nums){
            if(num >= 0){
                ans[i] = num;
                i += 2;
            }else{
                ans[j] = num;
                j +=2;
            }
        }

        return ans;
    }
    /*
        code if number of positive elements != number of negative elements
     */
    public static int[] rearrangeArray3(int[] nums) {
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        for(int num : nums){
            if(num >= 0){
                positive.add(num);
            }else{
                negative.add(num);
            }
        }
        int i = 0, j = 0, count = 0;
        while (i < positive.size() && j < negative.size()){
            nums[2 * i] = positive.get(i);
            nums[2 * j + 1] = negative.get(j);
            i++;
            j++;
            count++;
        }
        if(positive.size() > negative.size()){
            i = positive.size() - 1;
            j = nums.length - 1;
            while (i >= count){
                nums[j] = positive.get(i);
                i--;
                j--;
            }
        }else if(negative.size() > positive.size()){
            j = negative.size() - 1;
            i = nums.length - 1;
            while (j >= count){
                nums[i] = negative.get(j);
                i--;
                j--;
            }
        }else{
            return nums;
        }
        return nums;
    }
}
