import java.util.Stack;

public class PostfixEvaluation {

    public static int evaluatePostFix(String S)
    {
        // Your code here
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<S.length();i++){
            char c=S.charAt(i);
            if(Character.isDigit(c))
                stack.push(c-'0');
            else {
                if (stack.size() >= 2) {
                    int val1 = stack.pop();
                    int val2 = stack.pop();
                    switch (c) {
                        case '+':
                            stack.push(val2 + val1);
                            break;

                        case '-':
                            stack.push(val2 - val1);
                            break;

                        case '/':
                            stack.push(val2 / val1);
                            break;

                        case '*':
                            stack.push(val2 * val1);
                            break;
                    }
                }
                else{
                    System.out.println("Input is not postFix");
                    return -1;
                }
            }



        }
        return stack.pop();
    }

    static int evaluatePostfixMultipleDigits(String exp)
    {
        //create a stack
        Stack<Integer> stack = new Stack<>();

        // Scan all characters one by one
        for(int i = 0; i < exp.length(); i++)
        {
            char c = exp.charAt(i);

            if(c == ' ')
                continue;

                // If the scanned character is an operand
                // (number here),extract the number
                // Push it to the stack.
            else if(Character.isDigit(c))
            {
                int n = 0;

                //extract the characters and store it in num
                while(Character.isDigit(c))
                {
                    n = n*10 + (int)(c-'0');
                    i++;
                    c = exp.charAt(i);
                }
                i--;

                //push the number in stack
                stack.push(n);
            }

            // If the scanned character is an operator, pop two
            // elements from stack apply the operator
            else
            {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch(c)
                {
                    case '+':
                        stack.push(val2+val1);
                        break;

                    case '-':
                        stack.push(val2- val1);
                        break;

                    case '/':
                        stack.push(val2/val1);
                        break;

                    case '*':
                        stack.push(val2*val1);
                        break;
                }
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String str="231*+9-";
        System.out.println(evaluatePostFix(str));
        System.out.println(evaluatePostfixMultipleDigits("113 200 + 2 / 5 * 7 +"));


    }
}
