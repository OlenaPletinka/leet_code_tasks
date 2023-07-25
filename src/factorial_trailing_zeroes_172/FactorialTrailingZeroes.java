package factorial_trailing_zeroes_172;

/**
 * 172. Factorial Trailing Zeroes
 * https://leetcode.com/problems/factorial-trailing-zeroes/?envType=study-plan-v2&envId=top-interview-150
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
 */
public class FactorialTrailingZeroes {
  public int trailingZeroes(int n) {
    Integer factorial = getFactorial(n);
    int result = 0;
    while(factorial%10 == 0){
      factorial /= 10;
      result++;
    }
    return result;
  }
  private Integer getFactorial(int n){
    if(n == 0){
      return 1;
    }
    return n * getFactorial(n-1);
  }
  public static void main(String[] args) {
    FactorialTrailingZeroes trailingZeroes = new FactorialTrailingZeroes();
    System.out.println(trailingZeroes.trailingZeroes(30));
  }
}
