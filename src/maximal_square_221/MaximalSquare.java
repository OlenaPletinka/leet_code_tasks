package maximal_square_221;

/**
 * 221. Maximal Square
 *
 * https://leetcode.com/problems/maximal-square/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * Given an m x n binary matrix filled with 0's and 1's,
 * find the largest square containing only 1's and return its area.
 */
public class MaximalSquare {
  // dp bottom-up
  // time - O(m*n)
  // space - O(1)
  public int maximalSquare(char[][] matrix) {
    int result = 0;
    int row = matrix.length;
    int column = matrix[0].length;
    int[][]cache = new int[row+1][column+1];

    for(int i = row-1; i>=0; i--){
      for(int j = column-1; j>=0; j--){

        if (matrix[i][j] == '1') {
          int val = Math.min(cache[i + 1][j], Math.min(cache[i][j + 1], cache[i + 1][j + 1])) + 1;
          cache[i][j] = val;
          result = Math.max(result, val);
        }

      }
    }
    return result*result;
  }


  public static void main(String[] args) {
    MaximalSquare square = new MaximalSquare();
    System.out.println(square.maximalSquare(new char[][]{{'0','1'},
              {'1','0'}}));
  }
}
