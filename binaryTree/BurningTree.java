class Solution {
    /*
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    */
    static Node tar = null;

    public static int minTime(Node root, int target) {
        // Code here
        Map<Node, Node> map = new HashMap<>();
        collectMapping(map, root, target);

        int count = 0;
        Queue<Node> q = new LinkedList<>();
        Set<Node> v = new HashSet<>();
        q.add(tar);
        v.add(tar);

        while (!q.isEmpty()) {
             
            boolean flag =false;
            
            int size= q.size();
            for(int i=0;i<size;i++){
                Node curr =q.poll();
                if(curr.left!= null && !v.contains(curr.left)){
                q.add(curr.left);
                flag=true;
                v.add(curr.left);
            }
            if(curr.right!= null && !v.contains(curr.right)){
                q.add(curr.right);
                flag=true;
                v.add(curr.right);
            }
            if(map.containsKey(curr) && !v.contains(map.get(curr) )){
                q.add(map.get(curr) );
                flag=true;
                v.add(map.get(curr));
            }
            }
            if(flag)
            {
                count++;
            }
        }
        
        return count;
    }

    public static void collectMapping(Map<Node, Node> map, Node root, int target) {
        if (root == null) {
            return;
        }

        if (root.data == target) {
            tar = root;
        }

        if (root.left != null) {
            map.put(root.left, root);
        }

        if (root.right != null) {
            map.put(root.right, root);
        }

        collectMapping(map, root.left, target);
        collectMapping(map, root.right, target);
    }
}
