package com.dhanunjay.arrays.basics;

import java.util.ArrayList;
import java.util.List;

public class LeadersInAnArray {
    public static void main(String[] args) {
        int[] arr = {10,22,12,3,0,6};
        System.out.println(superiorElements1(arr));
        System.out.println(superiorElements2(arr));
    }
    public static List<Integer> superiorElements1(int []a) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < a.length; i++){
            boolean leader = true;
            for(int j = i + 1; j < a.length; j++){
                if(a[j] > a[i]){
                    leader = false;
                    break;
                }
            }
            if(leader){
                list.add(a[i]);
            }
        }
        return list;
    }
    public static List<Integer> superiorElements2(int []a) {
        List<Integer> list = new ArrayList<>();
        int max = a[a.length - 1];
        list.add(max);
        for(int i = a.length - 1; i >= 0; i--){
            if(max < a[i]){
                list.add(a[i]);
            }
            max = Math.max(max, a[i]);
        }
        return list;
    }
}
