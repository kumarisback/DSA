class Solution {
    int maxD=0;

    public int height(TreeNode root){
        if(root==null) return 0;
        int left=height(root.left);
        int right = height(root.right);
        maxD=Math.max(maxD, left+right);
        return Math.max(left, right) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxD;
    }
}
