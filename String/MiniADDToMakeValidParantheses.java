class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int c = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (stack.isEmpty() && s.charAt(i) == ')') {
                c++;
            } else {
                stack.pop();
            }
        }
        return stack.size() + c;
    }
}
