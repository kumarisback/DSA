class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // If the key to delete is smaller, recurse to the left subtree
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        // If the key to delete is greater, recurse to the right subtree
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        // Found the node to delete
        else {
            // Case 1: Node with only one child or no child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Case 2: Node with two children
            // Find the smallest value in the right subtree (in-order successor)
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val; // Replace the value
            root.right = deleteNode(root.right, minNode.val); // Delete the successor node
        }
        return root;
    }

    // Helper function to find the minimum value node
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
