package add_binary_67;

/**
 * 67. Add Binary
 * https://leetcode.com/problems/add-binary/?envType=study-plan-v2&envId=top-interview-150
 * Given two binary strings a and b, return their sum as a binary string.
 */
public class AddBinary {
  // time - O(max(m,n))
  // space - O(max(m,n))
  public String addBinary(String a, String b) {
    int carry = 0;
    StringBuilder builder = new StringBuilder();
    int i = a.length() - 1;
    int j = b.length() - 1;
    while (i >= 0 || j >= 0) {
      int x = i < 0 ? 0 : a.charAt(i--) - '0';
      int y = j < 0 ? 0 : b.charAt(j--) - '0';
      int sum = x + y + carry;
      builder.append(sum % 2);
      carry = sum / 2;

    }

    if (carry != 0) {
      builder.append(carry);
    }
    return builder.reverse().toString();
  }

  public static void main(String[] args) {
    AddBinary binary = new AddBinary();
    System.out.println(binary.addBinary("11", "1"));
  }
}
