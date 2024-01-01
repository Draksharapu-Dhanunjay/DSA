package com.dhanunjay.Arrays.Basics;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] array1 = {-1,1,2,2,3,3,4,5,6};
        int[] array2 = {-1,2,3,3,5,6,6,7};
        System.out.println(Intersection1(array1, array2));
        System.out.println(Intersection2(array1, array2));
    }
    /*
        BruteForce Approach:
        n -> array1.length
        m -> array2.length
        k -> the largest element length
        Time Complexity: O(n * m)
        Space Complexity: O(k)
     */
    public static List<Integer> Intersection1(int[] array1, int[] array2){
        List<Integer> intersection = new ArrayList<>();
        int n = Math.max(array1[array1.length - 1], array2[array2.length - 1]);
        int[] track = new int[n];
        for (int k : array1) {
            for (int j = 0; j < array2.length; j++) {
                if (k == array2[j] && track[j] != 1) {
                    intersection.add(k);
                    track[j]++;
                    break;
                }
                if (array2[j] > k) {
                    break;
                }
            }
        }
        return intersection;
    }
    /*
        Optimal Approach
        Time Complexity: O(min(n,m))
        Space Complexity: O(1)
     */
    public static List<Integer> Intersection2(int[] array1, int[] array2){
        int i = 0, j = 0, n = array1.length, m = array2.length;
        List<Integer> intersection = new ArrayList<>();
        while (i < n && j < m){
            if(array1[i] == array2[j]){
                intersection.add(array1[i]);
                i++;
                j++;
            }else if(array1[i] < array2[j]){
                i++;
            }else{
                j++;
            }
        }
        return intersection;
    }
}
