package camusbai.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by camusbai on 2/13/16.
 */
public class Problem102_BiTreeLvlOrderTrav {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root!=null)
            q.add(root);
        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            List<TreeNode> nodesOfSameLevel = new ArrayList<TreeNode>();
            while(!q.isEmpty()) {
                nodesOfSameLevel.add(q.remove());
            }
            for(TreeNode node: nodesOfSameLevel) {
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                level.add(node.val);
            }
            result.add(level);
        }
        return result;
    }
}
