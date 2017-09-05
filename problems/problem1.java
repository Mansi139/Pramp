/**
A sorted array of distinct integers shiftArr is shifted to the left by an unknown offset and you don’t have a pre-shifted copy of it. For instance, the sequence 1, 2, 3, 4, 5 becomes 3, 4, 5, 1, 2, after shifting it twice to the left.

Given shiftArr and an integer num, implement a function shiftedArrSearch that finds and returns the index of num in shiftArr. If num isn’t in shiftArr, return -1. Assume that the offset doesn’t equal to 0 (i.e. assume the array is shifted at least once) or to arr.length - 1 (i.e. assume the shifted array isn’t fully reversed).

Example:
input:  shiftArr = [9, 12, 17, 2, 4, 5], num = 2 # shiftArr is the
                                                 # outcome of shifting
                                                 # [2, 4, 5, 9, 12, 17]
                                                 # three times to the left

output: 3 # since it’s the index of 2 in arr

*/

import java.io.*;
import java.util.*;

class problem1 {

  static int shiftedArrSearch(int[] shiftArr, int num) {
    int start = 0, size = shiftArr.length;
    int end = shiftArr.length-1;
    while(start <= end){
      int mid = (start+end)/2;

      if(shiftArr[mid] == num) return mid;

      if(shiftArr[start] <= shiftArr[mid]){
        if(num >= shiftArr[start] && num <= shiftArr[mid]) end = mid-1;
        else start = mid+1;
      }else if(shiftArr[mid] <= shiftArr[end]){
        if(num >= shiftArr[mid] && num <= shiftArr[end]) start = mid+1;
        else end = mid-1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] num = new int[]{3,4,5,1,2}; //[2,3,1]

    System.out.println(shiftedArrSearch(num, 1));
  }

}
