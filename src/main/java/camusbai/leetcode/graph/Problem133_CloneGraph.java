package camusbai.leetcode.graph;

import java.util.*;

public class Problem133_CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> nodeCopy = new HashMap<>();
        createNodeCopy(node, nodeCopy);
        Set<Integer> visited = new HashSet<>();
        populateCopyWithNeighbor(node, visited, nodeCopy);

        return nodeCopy.get(node.label);
    }

    private void createNodeCopy(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> nodeCopy) {
        if (!nodeCopy.containsKey(node.label)) {
            UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
            nodeCopy.put(node.label, copy);
            for (UndirectedGraphNode neighbor : node.neighbors) {
                createNodeCopy(neighbor, nodeCopy);
            }
        }
    }

    private void populateCopyWithNeighbor(UndirectedGraphNode node, Set<Integer> visited, Map<Integer, UndirectedGraphNode> nodeCopy) {
        if (!visited.contains(node.label)) {
            visited.add(node.label);
            UndirectedGraphNode copy = nodeCopy.get(node.label);
            for (UndirectedGraphNode n : node.neighbors) {
                copy.neighbors.add(nodeCopy.get(n.label));
                populateCopyWithNeighbor(n, visited, nodeCopy);
            }
        }
    }


    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
}
