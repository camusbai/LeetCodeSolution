package camusbai.leetcode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by camusbai on 5/10/18.
 */
public class Problem20_validParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (isOpenParenthesis(c)) {
                stack.push(c);
            } else if (isClosingParenthesis(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char cc = getCorrespondingParenthesis(stack.pop());
                if (cc != c) {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isOpenParenthesis(char c) {
        return c=='('||c=='['||c=='{';
    }

    private static boolean isClosingParenthesis(char c) {
        return c==')'||c==']'||c=='}';
    }

    private static char getCorrespondingParenthesis(char c) {
        switch (c){
            case '(':
                return ')';
            case '[':
                return ']';
            case '{':
                return '}';
            default:
                return '\n';
        }
    }
}
