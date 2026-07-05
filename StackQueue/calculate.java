class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int num = 0;
        int sign = 1;

        for(int i = 0 ; i < s.length();i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                num = num * 10 +(c - '0');
            }

            else if( c == '-'){
                result+= num*sign;  
                sign = -1;
                num = 0; 
            }
            else if( c == '+'){
                result+= num*sign;
                sign = 1;
                num = 0; 
            }
            else if( c == '('){
                result+= num*sign;
                stack.push(result);
                stack.push(sign);

                result = 0;
                sign = 1;
                num = 0;
            }
            else if( c == ')'){
                
                result += num * sign;
                num = 0;

                int prevSign = stack.pop();
                int prevResult = stack.pop();

                result = prevResult + prevSign * result;
            }
        }
        result+= num * sign;
        return result;
    }
}
