package search2d_matrix_74;

/**
 * 74. Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/?envType=study-plan-v2&envId=top-interview-150
 *
 * You are given an m x n integer matrix matrix with the following two properties:
 *
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 *
 * You must write a solution in O(log(m * n)) time complexity.
 */
public class Search2DMatrix {
  // binary search
  // time - O(log n)
  // space - O(1)
  public boolean searchMatrix(int[][] matrix, int target) {
    int left = 0;
    int col = matrix[0].length;
    int right = matrix.length * col-1;

    int i = 0;
    int j = 0;
    while(left<right){
      int middle = left + (right-left)/2;
      i = middle / col;
      j = middle % col;
      if(matrix[i][j] < target){
        left = middle +1;
      }else{
        right = middle;
      }
    }
    return matrix[left/col][left%col] == target;

  }

  public static void main(String[] args) {
    Search2DMatrix search2DMatrix = new Search2DMatrix();
    System.out.println(search2DMatrix.searchMatrix(new int [][]{{1}}, 2));


  }
}
