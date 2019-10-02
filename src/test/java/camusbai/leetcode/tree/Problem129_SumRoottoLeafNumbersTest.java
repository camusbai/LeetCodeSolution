package camusbai.leetcode.tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by camusbai on 9/7/16.
 */
public class Problem129_SumRoottoLeafNumbersTest {
    TreeNode root;

    @Before
    public void setUp() throws Exception {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
    }

    @Test
    public void sumNumbers() throws Exception {
        Problem129_SumRoottoLeafNumbers sumRoottoLeafNumbers = new Problem129_SumRoottoLeafNumbers();
        System.out.println(sumRoottoLeafNumbers.sumNumbers(root));
    }

}