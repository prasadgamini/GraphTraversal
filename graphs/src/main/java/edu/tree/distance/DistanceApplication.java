package edu.tree.distance;

/**
 * https://www.geeksforgeeks.org/find-distance-between-two-nodes-of-a-binary-tree/#:~:text=The%20distance%20between%20two%20nodes,root%20of%20given%20Binary%20Tree.
 * Find the distance between two keys in a binary tree,
 * no parent pointers are given.
 * Distance between two nodes is the minimum number of edges to be traversed to reach one node from other.
 * <p>
 * Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca)
 * 'n1' and 'n2' are the two given keys
 * 'root' is root of given Binary Tree.
 * 'lca' is lowest common ancestor of n1 and n2
 * Dist(n1, n2) is the distance between n1 and n2.
 */
public class DistanceApplication {

    public int getDistance(int[] elements, int node1, int node2) {
        //construct the tree
        TreeNode rootNode = new TreeNode(elements[0]);
        for (int i = 1; i < elements.length; i++) {
            insert(rootNode, elements[i]);
        }

        inOrder(rootNode);
        System.out.println();
        int distanceToNode1 = getDistance(rootNode, node1, 0);
        int distanceToNode2 = getDistance(rootNode, node2, 0);
        System.out.println("Level of " + node1 + " :: " + distanceToNode1);
        System.out.println("Level of " + node2 + " :: " + distanceToNode2);
        if (distanceToNode1 == -1 || distanceToNode2 == -1) {
            return -1;
        }
        TreeNode lcaNode = getLowestAncestor(rootNode, node1, node2);
        System.out.println("LCA :: " + lcaNode.val);
        int distanceToLCA = getDistance(rootNode, getLowestAncestor(rootNode, node1, node2).val, 0);
        System.out.println("Level of LCA node " + lcaNode.val + " :: " + distanceToLCA);

        return distanceToNode1 + distanceToNode2 - 2 * distanceToLCA;
    }

    private void insert(TreeNode node, int val) {
        if (val < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
            } else {
                insert(node.left, val);
            }
        }
        if (val > node.val) {
            if (node.right == null) {
                node.right = new TreeNode(val);
            } else {
                insert(node.right, val);
            }
        }
    }

    private void inOrder(TreeNode node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        System.out.print(node.val + " ");
        if (node.right != null) {
            inOrder(node.right);
        }
    }

    private TreeNode getLowestAncestor(TreeNode node, int node1, int node2) {
        if (node.val > node1 && node.val > node2) {
            return getLowestAncestor(node.left, node1, node2);
        }
        if (node.val < node1 && node.val < node2) {
            return getLowestAncestor(node.right, node1, node2);
        }
        return node;
    }

    private int getDistance(TreeNode node, int val, int c) {
        if (node == null) {
            return -1;
        }
        if (node.val == val) {
            return c;
        }
        if (val < node.val) {
            return getDistance(node.left, val, c + 1);
        }
        return getDistance(node.right, val, c + 1);
    }

    public static void main(String[] args) {
        /*
                7
               / \
              4   12
             / \  /
            3  6 8
           /  /   \
          1   5   10
        */
        int[] elements = new int[]{7, 4, 12, 3, 6, 8, 1, 5, 10};
        DistanceApplication app = new DistanceApplication();
        int dist = app.getDistance(elements, 5, 10);
        System.out.println("Distance between 5 & 10 = " + dist);
        System.out.println("==============================================");
        System.out.println("Distance between 5 & 3 = " + app.getDistance(elements, 5, 3));
    }
}
