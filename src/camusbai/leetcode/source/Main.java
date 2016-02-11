package camusbai.leetcode.source;

import camusbai.leetcode.source.ArrayOperation.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    int[] arr = new int[3];
    System.out.println(arr.length);

    StringOperation so = new StringOperation();
    //String input = "Yo~ Lin, you are  awesome!!";
    String input = "the sky is blue";
    String output = so.reverseWords(input);
    System.out.println(output);

    String zigzag = "PAYPALISHIRING";
    System.out.println(StringOperation.convert(zigzag, 14));

    ArrayOperation ao = new ArrayOperation();
    //Two Sum
    int[] numbers = {9, 7, 11, 8, 1};
    int target = 9;
    int[] result = ao.twoSum(numbers, target);
    System.out.println(result[0] + ", " + result[1]);

    //Remove Duplicates from Sorted Array
    //int[] A = new int[]{1, 1, 1, 2, 3, 4, 4, 5,5,6,6,6,7,7,7,7,7,7};
    int[] A = new int[]{-2,-2,-2,-1,0,0,0,1,2,2,2,2,2,2,3,3,3};
    for(int i: A){
      System.out.print(Integer.toString(i) + ' ');
    }
    System.out.println();
    System.out.println(ao.removeDuplicates(A));


    //Binary Operation
    BinaryOperation bo =new BinaryOperation();
    int quotient = bo.divide(-2147483648, 214748364);
    //Integer Operation
    NumericOperation io = new NumericOperation();
    System.out.println(io.sqrt(8));
    System.out.println(quotient);
    System.out.println("Reverse integer: "+NumericOperation.reverse(-2147483641));
    System.out.println("Reverse integer: "+NumericOperation.reverse(2002));

    //matrix rotation
    int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    System.out.print("Original Matrix:");
    so.printMatrix(matrix, 4, 4);
    System.out.println("Rotated Matrix:");
    ao.rotate(matrix);
    so.printMatrix(matrix,4,4);

    //Tree Operation
    TreeOperation to = new TreeOperation();
    TreeOperation.TreeNode n1 = to.new TreeNode(1);
    TreeOperation.TreeNode n2 = to.new TreeNode(2);
    TreeOperation.TreeNode n3 = to.new TreeNode(3);
    TreeOperation.TreeNode n4 = to.new TreeNode(4);
    TreeOperation.TreeNode n5 = to.new TreeNode(5);
    TreeOperation.TreeNode n6 = to.new TreeNode(6);
    TreeOperation.TreeNode n7 = to.new TreeNode(7);
    TreeOperation.TreeNode n8 = to.new TreeNode(8);
    TreeOperation.TreeNode n9 = to.new TreeNode(9);
    TreeOperation.TreeNode n10 = to.new TreeNode(10);

    n1.left = n2; n1.right = n3;
    n2.left = n4; n2.right = n5;
    n3.left = n6; n3.right = n7;
    n4.left = n8; n4.right = n9;
    n5.left = n10;



    //List<List<Integer>> result1 = to.levelOrder(null);
    //List<List<Integer>> result1 = to.zigzagLevelOrder(root);
    //List<Integer> result2 = to.preorderTraversal(root);
    //List<Integer> result3 = to.postorderTraversal(root);

    System.out.println(to.maxDepth(n1));
    to.printAntiClockwise(n1,true,true);

    List<Interval> intervals = new ArrayList<Interval>();
    intervals.add(new Interval(1, 5));
//    intervals.add(new Interval(3, 5));
    intervals.add(new Interval(6, 8));
//    intervals.add(new Interval(8, 10));
//    intervals.add(new Interval(12, 16));

    List<Interval> result1 = ao.insert(intervals, new Interval(5, 6));
    System.out.println(result1);


  }
}