package com.dhanunjay.arrays.subsequence;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        System.out.println(combinationSum(arr, 7));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        combination(candidates,list,new ArrayList<>(), target, 0);
        return list;
    }
    public static void combination(int[] candidates,List<List<Integer>> list, ArrayList<Integer> ans, int target, int index){
        if(target == 0){
            list.add(new ArrayList<>(ans));
            return;
        }
        if(index == candidates.length){
            return;
        }
        if(candidates[index] <= target){
            ans.add(candidates[index]);
            combination(candidates,list, ans, target - candidates[index], index);
            ans.remove(ans.size() - 1);
        }

        combination(candidates,list, ans, target, index + 1);
    }
}
