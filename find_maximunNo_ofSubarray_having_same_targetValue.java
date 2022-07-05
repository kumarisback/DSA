 public int solve(int[] A, int B) {
     HashMap<Integer,Integer> visited = new HashMap<Integer,Integer>(); 
        int count = 0; 
        int xorVal = 0;
        int n = A.length;
        for(int i = 0;i<n;i++) {
            xorVal = xorVal ^ A[i]; 
            if(visited.get(xorVal^B) != null) 
                count += visited.get(xorVal ^ B); 
            if(xorVal == B) {
                count++; 
            }
            if(visited.get(xorVal) != null) 
                visited.put(xorVal, visited.get(xorVal) + 1); 
            else 
                visited.put(cpx, 1); 
        }
        return count; 
    }
