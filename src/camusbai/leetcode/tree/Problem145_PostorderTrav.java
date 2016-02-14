package camusbai.leetcode.tree;

import java.util.*;

/**
 * Binary Tree Postorder Traversal
 */
public class Problem145_PostOrderTrav {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        Map<TreeNode, Boolean> visited = new HashMap<TreeNode, Boolean>();
        if(root!=null)
            nodeStack.push(root);
        while(!nodeStack.empty()){
            TreeNode top = nodeStack.peek();
            boolean goRight = (top.right != null && (!visited.containsKey(top.right)));
            boolean goLeft = (top.left != null && (!visited.containsKey(top.left)));
            if (goRight) {
                nodeStack.push(top.right);
            }
            if (goLeft) {
                nodeStack.push(top.left);
            }
            if(!goRight&&!goLeft){
                TreeNode node = nodeStack.pop();
                result.add(node.val);
                visited.put(node, Boolean.TRUE);
            }
        }
        return  result;
    }
}
