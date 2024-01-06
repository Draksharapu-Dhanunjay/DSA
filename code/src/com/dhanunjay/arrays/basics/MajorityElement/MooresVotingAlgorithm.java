package com.dhanunjay.arrays.basics.MajorityElement;
/*
    Time Complexity: O(N) + O(N) : O(2N) : O(N)
    Space Complexity: O(1)
 */
public class MooresVotingAlgorithm {
    public static void main(String[] args) {
        int[] arr = {7,7,5,7,5,1,5,7,5,5,7,7,7,7,7,7};
        int element = arr[0], count = 0;
        for (int j : arr) {
            if (element == j) {
                count++;
            } else if (count == 0) {
                element = j;
                count = 1;
            } else {
                count--;
            }
        }
        count = 0;
        for(int num: arr){
            if(element == num){
                count++;
            }
        }
        if(count > arr.length /2){
            System.out.println("Majority Element :" + element);
        }else{
            System.out.println("Majority Element doesn't exist!");
        }

    }
}
