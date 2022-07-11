  public Node copyRandomList(Node head) {
    Map<Node, Node> mp = new HashMap<>();
        Node first = head;
        
        while(head != null)
        {
            if (!mp.containsKey(head))
            {
                mp.put(head, new Node(head.val)); 
            }
            
            if (head.next != null && !mp.containsKey(head.next))
            {
                mp.put(head.next, new Node(head.next.val));
            }
            
            if (head.random != null && !mp.containsKey(head.random))
            {
                mp.put(head.random, new Node(head.random.val));
            }
            
            Node current = mp.get(head);
            
            Node next = null;
            if(head.next != null)
                next = mp.get(head.next);
            
            Node random = null;
            if(head.random != null)
                random = mp.get(head.random);
            
            current.next = next;
            current.random =random;
            
            head = head.next;
        }
        
        return mp.get(first);}
}
