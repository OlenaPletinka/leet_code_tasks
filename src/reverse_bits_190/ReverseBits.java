package reverse_bits_190;

import java.util.Arrays;
import java.util.List;

/**
 * 190. Reverse Bits
 *
 * https://leetcode.com/problems/reverse-bits/?envType=study-plan-v2&envId=top-interview-150
 *
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * Note:
 *
 * Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output
 * will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary
 * representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above,
 * the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 */
public class ReverseBits {
  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    int result = 0;
    for(int i = 0; i < 32; i++){
      result<<=1; // з появою першої одинички починаємо рухати її вліво, якщо перші нулі вони просто скіпаються
      result |= n&1; // якщо останній біт одиничка то додаємо її в резалт
      n >>=1; // відрізаємо останній правий біт
    }
    return result;
  }

  public static void main(String[] args) {
    ReverseBits reverseBits = new ReverseBits();
    System.out.println(reverseBits.reverseBits(43261596));

  }

}
