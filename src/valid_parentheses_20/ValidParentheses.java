package valid_parentheses_20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class ValidParentheses {
  public boolean isValid(String s) {
    Map<Character, Character> map = new HashMap<>();
    map.put('}', '{');
    map.put(')', '(');
    map.put(']', '[');

    Stack<Character> stack = new Stack<>();
    for(int i = 0; i<s.length(); i++){
      char c = s.charAt(i);

      if(c == '{' || c == '(' || c == '['){
        stack.push(c);
        continue;
      }

      if(stack.isEmpty() || map.get(c) != stack.pop()){
        return false;
      }
    }

    return stack.size() == 0;

  }
}
