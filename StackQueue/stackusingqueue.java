class MyStack {

    public Queue<Integer> q=new LinkedList<>();;
    public MyStack() {
        
    }
    
    public void push(int x) {
        q.add(x);
        for(int i=0;i<q.size()-1;i++){
            int top=q.poll();
            q.add(top);
        }
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}
