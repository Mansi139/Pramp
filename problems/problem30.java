/**
 * Number of Paths
 * You’re testing a new driverless car that is located at the Southwest (bottom-left) corner of an n×n grid. The car is supposed to get to the opposite, Northeast (top-right), corner of the grid. Given n, the size of the grid’s axes, write a function numOfPathsToDest that returns the number of the possible paths the driverless car can take.
 */
import java.io.*;
import java.util.*;

class problem30 {

  static int numOfPathsToDest(int n) {
    int[][] memo = new int[n][n];
    memo[0][0] = 1;

    //first row = 1
    for(int i = 1; i < n; i++){
      memo[0][i] = 1;
    }
    //i = row, j = col
    for(int i = 1; i < n; i++){
      for(int j = i; j < n; j++){
        if(i == j ) memo[i][j] = memo[i-1][j];
        else memo[i][j] = memo[i][j-1]+memo[i-1][j];

      }
    }
    return memo[n-1][n-1];
  }

  public static void main(String[] args) {
       System.out.println(numOfPathsToDest(4));
  }

}
