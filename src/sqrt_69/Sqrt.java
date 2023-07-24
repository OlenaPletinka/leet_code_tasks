package sqrt_69;

/**
 * 69. Sqrt(x)
 * https://leetcode.com/problems/sqrtx/
 *
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
 *
 * You must not use any built-in exponent function or operator.
 *
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 *

 */
public class Sqrt {
  public int mySqrtBS(int x) {
    int l = 1;
    int r = x;
    return binarySearch(x, l,r);

  }

  public int mySqrt(int x) {
    long r = x;
    while (r*r>x){
      r = (r+x/r)/2;
    }
    return (int)r;
  }

//   * time - O(logn)
// * space - O(1)
  private int binarySearch(int x, int l, int r) {
    while (l<=r){
      int middle = l + (r-l)/2;
      if(x/middle==middle){
        return middle;
      }else if(x/middle>middle){
        l = middle+1;
      }else{
        r = middle-1;
      }
    }
    return r;
  }
}
