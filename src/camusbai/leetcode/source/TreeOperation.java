package camusbai.leetcode.source;

import java.util.*;

/**
 * Created by camusbai on 6/17/2014.
 */
public class TreeOperation {

  public void printAntiClockwise(TreeNode t, boolean pureLeft, boolean pureRight){
    if (t == null) return;

    boolean printed = false;
    if (pureLeft ||
            ((t.left == null) && (t.right == null))){
      System.out.print( Integer.toString(t.val)+' ');
      printed = true;
    }

    printAntiClockwise(t.left, pureLeft && true, false);

    printAntiClockwise(t.right, false, pureRight && true);

    if (pureRight && !pureLeft && !printed){
      System.out.print(Integer.toString(t.val)+' ');
    }
  }

  /*
  * Below are binary tree based:
  *
  * int maxDepth(TreeNode root);
  * List<Integer> preorderTraversal(TreeNode root);
  * List<Integer> postorderTraversal(TreeNode root);
  * List<List<Integer>> levelOrder(TreeNode root)
  * */
  public int maxDepth(TreeNode root) {
    if(root == null) return 0;
    return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
  }

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

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    boolean leftToRight = true;
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
      }
      if(leftToRight){
        for(TreeNode node: nodesOfSameLevel) {
          level.add(node.val);
        }
        leftToRight = false;
      }
      else{
        for(int i = nodesOfSameLevel.size()-1;i>-1;--i) {
          level.add(nodesOfSameLevel.get(i).val);
        }
        leftToRight = true;
      }
      result.add(level);
    }
    return result;
  }

  public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
  }
}
