package com.dhanunjay.arrays.basics;

import java.util.*;

public class UnionOfSortedArray {
    public static void main(String[] args) {
        int[] array1 = {1,1,3,4,5};
        int[] array2 = {2,3,4,4,5,6,6,6,7};
        System.out.println(Arrays.toString(union1(array1, array2)));
        System.out.println(union2(array1, array2));
    }
    /*
        BruteForce Approach:
        n -> array1.length
        m -> array2.length
        Time Complexity: O(n) + O(m) + O(n + m) : O(2 * (n + m))
        Space Complexity: O(n + m) + O(n + m) : O(2 * (n + m))
     */
    public static int[] union1(int[] array1, int[] array2){
        Set<Integer> union = new HashSet<>();
        for(int num : array1){
            union.add(num);
        }
        for(int num: array2){
            union.add(num);
        }
        int index = 0;
        int[] ans = new int[union.size()];
        for(int num: union){
            ans[index] = num;
            index++;
        }
        return ans;
    }
    /*
        Optimal Approach
        Time Complexity: O(n + m)
        Space Complexity: O(1)
     */
    public static List<Integer> union2(int[] array1, int[] array2){
        int i = 0, j = 0, n = array1.length, m = array2.length;
        List<Integer> union = new ArrayList<>();
        while (i < n && j < m){
            if(array1[i] <= array2[j]){
                if(!union.contains(array1[i])){
                    union.add(array1[i]);
                }
                i++;
            }else{
                if(!union.contains(array2[j])){
                    union.add(array2[j]);
                }
                j++;
            }
        }
        while (i < n){
            if(!union.contains(array1[i])){
                union.add(array1[i]);
            }
            i++;
        }
        while (j < m){
            if(!union.contains(array2[j])){
                union.add(array2[j]);
            }
            j++;
        }
        return union;
    }
}
