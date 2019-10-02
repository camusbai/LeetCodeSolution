package camusbai.leetcode.tree;

/**
 * Created by camusbai on 2/13/16.
 */
public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode(int x){val = x;}

    public int getVal() {
        return val;
    }

    public TreeNode generateTree(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 =new TreeNode(10);

        n1.left = n2; n1.right = n3;
        n2.left = n4; n2.right = n5;
        n3.left = n6; n3.right = n7;
        n4.left = n8; n4.right = n9;
        n5.left = n10;

        return n1;
    }
}
