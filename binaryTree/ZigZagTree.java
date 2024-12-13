class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean flag= false;

        List<List<Integer>> list= new ArrayList<>();

        Deque<TreeNode> deque= new LinkedList<>();

        if(root==null) return list;

        deque.add(root);

        while(!deque.isEmpty()){
            int size= deque.size();

            List<Integer> temp= new ArrayList<>();


            for(int i=0;i<size;i++){
                if(flag){
                   TreeNode el= deque.removeLast();
                   if(el.right!=null) deque.addFirst(el.right);
                   if(el.left!=null) deque.addFirst(el.left);
                   temp.add(el.val);
                }
                else{
                    TreeNode ela= deque.removeFirst();
                   
                   if(el.left!=null) deque.addLast(el.left);
                   if(el.right!=null) deque.addLast(el.right);
                   temp.add(el.val);
                }
                    
            }
            list.add(temp);
            flag=!flag;
        }
        
        return list;
    }
}
