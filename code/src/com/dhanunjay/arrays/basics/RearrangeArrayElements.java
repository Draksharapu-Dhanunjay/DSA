package com.dhanunjay.arrays.basics;

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeArrayElements {
    public static void main(String[] args) {
        int[] arr = {3, 1, -2, -5, 2, -4};
        System.out.println(Arrays.toString(rearrangeArray1(arr)));
        System.out.println(Arrays.toString(rearrangeArray2(arr)));
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
}
