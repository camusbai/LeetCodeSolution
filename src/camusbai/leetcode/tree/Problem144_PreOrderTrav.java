package camusbai.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by camusbai on 2/13/16.
 */
public class Problem144_PreOrderTrav {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        if(root!=null)
            nodeStack.push(root);
        while(!nodeStack.empty()){
            TreeNode node = nodeStack.pop();
            if(node.right!=null)
                nodeStack.push(node.right);
            if (node.left != null)
                nodeStack.push(node.left);
            result.add(node.val);
        }
        return result;
    }
}
