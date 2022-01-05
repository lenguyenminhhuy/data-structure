import java.util.Stack;

public class Question3 {
    Stack<Character> st = new Stack<>();
    public boolean isBalance(String s){
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (c == '[' || c == '{' || c == '('){
                st.push(c);
                continue;
            }
            if (st.isEmpty()){
                return false;
            }
            char c2 = st.peek();
            st.pop();
            if ((c == '[' && c2 != ']') || (c == '{' && c2 != '}') || (c == '(' && c2 != ')')){
                return false;
            }
        }
        if (!st.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        String s = "({})";
        Question3 q = new Question3();
        System.out.println(q.isBalance(s));
    }
}
