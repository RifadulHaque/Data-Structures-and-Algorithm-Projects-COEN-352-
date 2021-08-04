
/*

Write a program (in java) that takes from standard input an expression without left
parentheses and prints the equivalent infix expression with the parentheses inserted.

For example,
given the input:
1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )

your program should print
(( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) )


 */


import java.util.Stack;

public class A1Q1 {

    public static void main(String[] args) {

        // ((1*(8+3)+(2*(3-1)))
        // 1/8+3)*2)+2*3-10))
        String inputUser = "1+2)*3-4)*5-6)))";

        Stack<Character> operators = new Stack<>();
        Stack<String> factors = new Stack<>();

        for (int i = 0; i < inputUser.length(); i++) {

            char c = inputUser.charAt(i);
            if (c != ')') {
                if (c != '+' && c != '*' && c != '/' && c != '-') {
                    factors.push(c + ""); // 0-9
                }
                else {
                    operators.push(c);
                }
            } else {
                // found ')'
                String f1 = factors.pop();
                String f2 = factors.pop();
                char operator = operators.pop();

                String temp = '(' + f2 + operator + f1 + ')' ;
                //System.out.println(temp);
                factors.push(temp);
            }
        }
         System.out.print(factors.pop());


        while (!factors.isEmpty()) {
            String f1 = factors.pop();
            if (factors.isEmpty()) {
                System.out.println(f1);
                return;
            }
            else {
                String f2 = factors.pop();
                String f3 = '(' + f2 + operators.pop() + f1 + ')';
                factors.push(f3);
            }
        }

    }
}
