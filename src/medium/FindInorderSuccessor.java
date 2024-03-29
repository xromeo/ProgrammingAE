/**
 * In Binary Tree, Inorder successor of a node is the next node in Inorder traversal of the Binary Tree. Inorder Successor is NULL for the last node in Inorder traversal. 
 * In Binary Search Tree, Inorder Successor of an input node can also be defined as the node with the smallest key greater than the key of the input node. So, it is sometimes important to find next node in sorted order.
 * 
 *        
                   15
                 /    \
                /      \
               10       20
              / \      /  \
             /   \    /    \
            8    12  16    25
        
– The inorder successor of 8 is 10
– The inorder successor of 12 is 15
– The inorder successor of 25 does not exist.
*/

package medium;

import java.util.Scanner;

// Structure of a BST node
class Node {
    int val;
    Node left = null, right = null, parent = null;

    Node(int val) {
        this.val = val;
    }
}

class FindInorderSuccessor {
    // Recursive function to insert a key into a BST
    public static Node insert(Node root, int key) {
        // create a new node if the root is null
        if (root == null) {
            return new Node(key);
        } else if (key < root.val) {
            Node temp = insert(root.left, key);
            root.left = temp;
            temp.parent = root;
        } else {
            Node temp = insert(root.right, key);
            root.right = temp;
            temp.parent = root;
        }
        return root;
    }

    // function to locate node whose inorder successor is to be found
    public static Node SearchBST(Node root, int key) {
        if (root == null || root.val == key) {
            return root;
        } else if (root.val < key) {
            return SearchBST(root.right, key);
        } else if (root.val > key) {
            return SearchBST(root.left, key);
        }
        return null;
    }

    /* Function to find minimum value node in a given BST */
    public static Node findMinimum(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    /* Function to find an inorder successor */
    public static Node InorderSuccessor(Node root, int node) {
        Node n = SearchBST(root, node);
        // if right subtree exists
        if (n.right != null) {
            return findMinimum(n.right);
        }
        // if node does not have a right subtree travel up using parent pointer
        Node p = n.parent;
        while (p != null && n == p.right) {
            n = p;
            p = p.parent;
        }
        return p;
    }

    /* Driver Code */
    public static void main(String[] args) {
        int size, i, key;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        size = sc.nextInt();
        int[] arr = new int[size];
        System.out.print("Enter array elements: ");
        for (i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        Node root = null;
        for (i = 0; i < size; i++) {
            key = arr[i];
            root = insert(root, key);
        }
        for (i = 0; i < size; i++) {
            key = arr[i];
            Node succ = InorderSuccessor(root, key);
            if (succ != null)
                System.out.println("The successor of node " + key + " is " + succ.val);
            else
                System.out.println("The successor of node " + key + " is NULL");
        }
    }
}

