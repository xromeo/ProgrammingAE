package medium;

import java.util.ArrayList;
import java.util.List;

/*
 Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

 

Example 1:
            5
           / \
          4   8
         /   / \   
        11  13  4        
       / \     / \ 
      7   2   5   1

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22

Example 2:
            1
           / \
          2   3

Input: root = [1,2,3], targetSum = 5
Output: []

Example 3:
            1
           / 
          2  

Input: root = [1,2], targetSum = 0
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000

 */
public class PathSumII {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    public static void bts2(TreeNode node, int sum, List<Integer> branch, int target, List<List<Integer>> result) {
        if (node != null) {
            sum += node.val;

            if (node.left == null && node.right == null && sum == target) {
                branch.add(node.val);
                result.add(branch);
            }
            List<Integer> branchLeft = new ArrayList<>(branch);
            List<Integer> branchRight = new ArrayList<>(branch);
            branchLeft.add(node.val);
            branchRight.add(node.val);
            bts(node.left, sum, branchLeft, target, result);
            bts(node.right, sum, branchRight, target, result);
        }
    }

    public static void bts(TreeNode node, int sum, List<Integer> branch, int target, List<List<Integer>> result) {
        if (node != null) {
            sum += node.val;
            branch.add(node.val);

            if (node.left == null && node.right == null && sum == target) {
                result.add(new ArrayList<>(branch));
            }
            bts(node.left, sum, branch, target, result);
            bts(node.right, sum, branch, target, result);

            branch.remove(branch.size() - 1);
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        int sum = 0;
        List<Integer> branch = new ArrayList();
        List<List<Integer>> result = new ArrayList<>();
        bts(root, sum, branch, targetSum, result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(0);
        root.right.right.right = new TreeNode(1);

        System.out.println(pathSum(root, 22));
    }

}
