import java.util.Stack;

public class InfixToPostFix {

    static int Prec(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
    public static String infixToPostfix(String exp) {
        // Your code here
        Stack<Character> stack=new Stack();
        String result = new String("");
        for(int i=0;i<exp.length();i++)
        {
            char c=exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                result+=c;
            }
            else if(c=='(')
                stack.push(c);
            else if (c == ')'){
                while(!stack.isEmpty() &&
                        stack.peek() != '(')
                    result += stack.pop();

                    stack.pop();

            }
            else{
                while (!stack.isEmpty() && Prec(c)
                        <= Prec(stack.peek())){

                    result += stack.pop();
                }
                stack.push(c);
            }

        }
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }
    public static void main(String[] args) {
        String str="(a+b)*(c+d)";
        System.out.println(infixToPostfix(str));
    }
}
