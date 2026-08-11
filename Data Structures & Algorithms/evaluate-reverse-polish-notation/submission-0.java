class Solution {
    private boolean check(String t) {
        if(t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/"))
        return true;
        else return false;
    }
    private int operate(int a,int b,String op) {
        if(op.equals("*")) return a * b;
        else if(op.equals("+")) return a + b;
        else if(op.equals("-")) return a - b;
        else return a / b;
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String token : tokens) {
            if(check(token)) {
                int b = st.pop();
                int a = st.pop();
                int ans = operate(a,b,token);
                st.push(ans);
            }
            else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.peek(); 
    }
}
