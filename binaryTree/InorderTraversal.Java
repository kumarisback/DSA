
class Solution {

    public void call(TreeNode root, List<Integer> list){
        if (root != null) {
            // Traverse the left subtree
            call(root.left, list);
            // Visit the root node
            list.add(root.val);
            // Traverse the right subtree
            call(root.right, list);
        }

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list= new ArrayList<>();

        call(root,list);
        return list;
    }
}
