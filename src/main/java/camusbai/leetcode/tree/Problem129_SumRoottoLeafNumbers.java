package camusbai.leetcode.tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by camusbai on 9/6/16.
 */
public class Problem129_SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;

        int sum = 0, num = root.val;
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode n = stack.peek();
            if (n.left != null && !visited.contains(n.left)) {
                stack.push(n.left);
                visited.add(n.left);
                num = num * 10 + n.left.val;
            } else if (n.right != null && !visited.contains(n.right)) {
                stack.push(n.right);
                visited.add(n.right);
                num = num * 10 + n.right.val;
            } else {
                if (n.left == null && n.right == null)
                    sum += num;
                num /= 10;
                stack.pop();
            }
        }

        return sum;
    }
}
