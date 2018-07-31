package camusbai.leetcode.string;

import camusbai.leetcode.arraylist.Problem39_Combination_Sum;

import java.util.ArrayList;
import java.util.List;

public class Problem22_generate_parenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            System.out.println(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    public static void main(String[] args) {
        new Problem22_generate_parenthesis().generateParenthesis(4);
    }
}
