package Stacks;

// Reverse Polish Notation. Evaluate Postfix Notation.

import java.util.Stack;

public class RPN {

    private static int rpn(String[] tokens) {
        String operators = "+-*/";
        Stack<String> stack = new Stack<>();
        for (String t : tokens) {
            if (!operators.contains(t)) {
                //push to stack if it is a number
                stack.push(t);
            } else {
                //pop numbers from stack if it is an operator
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                switch (t) {
                    case "+":
                        stack.push(String.valueOf(a + b));
                        break;
                    case "-":
                        stack.push(String.valueOf(b - a));
                        break;
                    case "*":
                        stack.push(String.valueOf(a * b));
                        break;
                    case "/":
                        stack.push(String.valueOf(b / a));
                        break;
                }
            }
        }
        return Integer.valueOf(stack.pop());
    }

    public static void main(String[] args){
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(rpn(tokens));
    }
}
