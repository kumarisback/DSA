class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();

        for (int i : asteroids) {
            boolean destroyed = false;
            while (!stk.isEmpty() && i < 0 && stk.peek() > 0) {
                if (Math.abs(i) > Math.abs(stk.peek())) {
                    stk.pop();
                } else if (Math.abs(stk.peek()) == Math.abs(i)) {
                    // Both asteroids destroy each other
                    stk.pop();
                    destroyed = true;
                    break;
                } else {
                    // Current asteroid explodes
                    destroyed = true;
                    break;
                }

            }
            if (!destroyed)
                stk.push(i);

        }
        return stk.stream().mapToInt(Integer::intValue).toArray();

    }
}
