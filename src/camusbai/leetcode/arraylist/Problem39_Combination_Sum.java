package camusbai.leetcode.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


public class Problem39_Combination_Sum {
    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        List<List<Integer>> result = new Problem39_Combination_Sum().combinationSum(candidates, 7);
        System.out.println(result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // init
        Stack<Node> stack = new Stack<>();
        for (int cand : candidates) {
            Node node = new Node(cand);
            stack.push(node);
        }
        ReusltChecker reusltChecker = new ReusltChecker();
        List<List<Integer>> combinations = new ArrayList<>();
        //DFS
        while (!stack.isEmpty()) {
            Node n = stack.peek();
            if (n.children != null) {
                reusltChecker.removeLast();
                stack.pop();
                continue;
            }
            int sum = reusltChecker.add(n.val);
            if (sum < target) {
                initChildren(n, candidates);
                for (Node child : n.children) {
                    stack.push(child);
                }
            } else if (sum == target) {
                List<Integer> result = reusltChecker.generateReuslt();
                if (!listExist(combinations, result)) {
                    combinations.add(result);
                }
                reusltChecker.removeLast();
                stack.pop();
            } else {
                reusltChecker.removeLast();
                stack.pop();
            }
        }

        return combinations;
    }

    private boolean listExist(List<List<Integer>> resultList, List<Integer> result) {
        for (List<Integer> list : resultList) {
            if (list.equals(result)) {
                return true;
            }
        }

        return false;
    }

    private void initChildren(Node node, int[] candidates) {
        Node[] children = new Node[candidates.length];
        for (int i = 0; i < candidates.length; i++) {
            Node child = new Node(candidates[i]);
            children[i] = child;
        }
        node.children = children;
    }

    private static class Node{
        int val;
        Node[] children;

        public Node(int val) {
            this.val = val;
        }

        public void setChildren(Node[] children) {
            this.children = children; }

    }

    private static class ReusltChecker{
        List<Integer> result = new ArrayList<>();
        int sum = 0;

        public int add(int num) {
            result.add(num);
            sum += num;
            return sum;
        }

        public void removeLast() {
            int lastNum = result.remove(result.size() - 1);
            sum -= lastNum;
        }

        public int getSum() {
            return sum;
        }

        public List<Integer> generateReuslt() {
            List<Integer> copy = new ArrayList<>(result);
            Collections.sort(copy);
            return copy;
        }
    }
}
