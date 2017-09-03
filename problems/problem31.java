import java.util.*;
/**
 * Pairs with Specific Difference

Given an array arr of distinct integers and a nonnegative integer k, write a function findPairsWithGivenDifference that returns an array of all pairs [x,y] in arr, such that x - y = k. If no such pairs exist, return an empty array.

In your solution, try to reduce the memory usage while maintaining time efficiency. Prove the correctness of your solution and analyze its time and space complexities.
 */

public class problem31{
  public static void main(String[] args){

    int[] arr = new int[]{0,-1,-2,2,1};
    int[][] res = findPairsWithGivenDifference(arr,1);

  }

  public static int[][] findPairsWithGivenDifference(int[] arr, int k){
    ArrayList<Integer> res = new ArrayList<Integer>();
    int[][] resArr;

    //sort the array and use 2-pointers
    Arrays.sort(arr);

    int start = 0, end = 1;
    while(start < arr.length && end < arr.length){
      if((arr[end]-arr[start]) == k) {
        res.add(arr[end]);
        res.add(arr[start]);
        end++;
      }else if((arr[end] - arr[start]) < k){
        end++;
      }else{
        start++;
      }
    }

    //from arraylist to arr
    resArr = new int[res.size()/2][2];
    int j = 0;
    for(int i = 0; i < res.size()-1; i=i+2){
      resArr[j][0] = res.get(i);
      resArr[j][1] = res.get(i+1);
      j++;
    }

    //print pairs
    for(int i = 0; i < resArr.length; i++){
        System.out.println("pair : " + resArr[i][0] + resArr[i][1]);
    }
    return resArr;
  }
}
