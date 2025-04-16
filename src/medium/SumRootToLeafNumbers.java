package medium;

import java.util.*;
import java.util.stream.Collectors;


/*
 You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.

 

Example 1:

  1
 / \
2   3 

Input: root = [1,2,3]
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:
    4 
   / \
  9   0
 / \
5   1 

Input: root = [4,9,0,5,1]
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 9
The depth of the tree will not exceed 10. 
 
 */

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        int branch = 0;
        List<Integer> list = new ArrayList<>();
        dfs(root, branch, list);
        System.out.println(list);
        return list.stream()
                .collect(Collectors.summingInt(Integer::intValue));
    }

    public void dfs(TreeNode node, int branch, List<Integer> list) {
        if (node != null) {

            branch = branch * 10 + node.val;
            // If it's a leaf node, add the current branch to the list
            if (node.left == null && node.right == null) {
                list.add(branch);
                System.out.println("Leaf node reached, adding number: " + branch);
                return; // Stop further traversal down this path
            }

            dfs(node.left, branch, list);
            dfs(node.right, branch, list);
        }
    }

    public static void main(String[] args) {
        // Create a simple binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(5);

        // Create an instance of SumRootToLeafNumbers
        SumRootToLeafNumbers solver = new SumRootToLeafNumbers();

        // Calculate the sum of root-to-leaf numbers
        int sum = solver.sumNumbers(root);

        // Print the result
        System.out.println("Sum of root-to-leaf numbers: " + sum);
    }
}