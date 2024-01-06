// array -> 0 to n find missing number
package com.dhanunjay.arrays.basics;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1,0,3,2,5};
        System.out.println(missingNumber1(arr));
        System.out.println(missingNumber2(arr));
        System.out.println(missingNumber3(arr));
        System.out.println(missingNumber4(arr));
        System.out.println(missingNumber5(arr));
    }
    /*
        BruteForce Approach
        Time Complexity: O(n * n)
        Space Complexity: O(1)
     */
    public static int missingNumber1(int[] arr){
        for(int i = 1; i <= arr.length; i++){
            boolean flag = false;
            for (int k : arr) {
                if (i == k) {
                    flag = true;
                    break;
                }
            }
            if(!flag){
                return i;
            }
        }
        return -1;
    }
    /*
        Bette Approach
        Time Complexity: O(n) + O(n) : O(2n) : O(n)
        Space Complexity: O(n)
     */
    public static int missingNumber2(int[] arr){
        int[] hashArr = new int[arr.length + 1];
        for(int i : arr){
            hashArr[i]++;
        }
        for(int i = 0; i < hashArr.length; i++){
            if(hashArr[i] ==0){
                return i;
            }
        }
        return -1;
    }
    public static int missingNumber3(int[] arr){
        int i = 0, n =arr.length;
        while (i < n){
            if(arr[i] != i){
                int temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
            }
            if(arr[i] == i){
                i++;
            }
            if(arr[i] == n){
                i++;
            }
        }
        for(int j = 0; j < n; j++){
            if(arr[j] != j){
                return j;
            }
        }
        return -1;
    }
    /*
        Optimal Approach
        Time Complexity: O(n)
        Space Complexity: O(1)
     */
    public static int missingNumber4(int[] arr){
        int n = arr.length , sum = 0;
        for(int i : arr){
            sum += i;
        }
        return (n * ( n + 1 )/2) - sum;
    }
    public static int missingNumber5(int[] arr){
        int value = 0;
        for(int i = 0; i < arr.length; i++){
            value = i ^ arr[i];
        }
        return value  ^ arr.length;
    }
}
