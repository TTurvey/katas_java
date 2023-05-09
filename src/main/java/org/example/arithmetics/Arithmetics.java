package org.example.arithmetics;

import java.util.*;

public class Arithmetics {

    // A utility function to return precedence of a given operator
    // Higher returned value means higher precedence
    static int Precedence(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    public String execute(String input) throws InvalidRecordException {
        String infixExpression = removeWhitespace(input);

        //  Check for all operations inside parentheses
        checkAllOperationsAreInParentheses(infixExpression);

        //  Check for even number of parentheses
        int parenthesesCount = countParentheses(infixExpression);
        checkEvenParentheses(parenthesesCount);

        //  Convert infix expression to postfix expression
        //  It is easier to evaluate postfix.
        String postfixExpression = convertToPostfix(infixExpression);

        //  Solve the postfix expression
        return solvePostfix(postfixExpression);
    }

    public void checkAllOperationsAreInParentheses(String str) throws InvalidRecordException {
        char c = str.charAt(0);
        String s = String.valueOf(c);
        if (!s.equals("(")) throw new InvalidRecordException("Invalid record error");
    }

    public int countParentheses(String str) {
        return (int) str.chars().filter(ch -> ch == '(' || ch == ')').count();
    }

    public void checkEvenParentheses(int num) throws InvalidRecordException {
        if (num % 2 != 0) throw new InvalidRecordException("Invalid record error");
    }

    public String convertToPostfix(String infixExpression) {
        // Initializing empty String for result
        StringBuilder result = new StringBuilder();

        // Initializing empty stack.
        // Deque is an interface whereas Stack is a class.
        // Java supports the inheritance of multiple interfaces.
        // Java doesn't support multiple inheritance of classes.
        // Therefore, using Deque for a stack is more flexible.
        // Can also insert/remove from both ends unlike Stack.
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < infixExpression.length(); ++i) {
            char c = infixExpression.charAt(i);

            // If the scanned char is an operand, add it to output.
            if (Character.isLetterOrDigit(c)) {result.append(c);}
            // If the scanned char is an '(', push it to the stack.
            else if (c == '(') {stack.push(c);}
            // If the scanned char is ')', pop and output from the stack until an '(' is encountered.
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.peek());
                    stack.pop();
                }
                stack.pop();
            }
            // An operator is encountered
            else {
                while (!stack.isEmpty() && Precedence(c) <= Precedence(stack.peek())) {
                    result.append(stack.peek());
                    stack.pop();
                }
                stack.push(c);
            }
        }

        // Pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result.append(stack.peek());
            stack.pop();
        }

        if (result.length() == 0) return "0";

        return result.toString();
    }

    public String removeWhitespace(String string) {
        return string.replaceAll(" ", "");
    }

    public String solvePostfix(String postfixExpression) {
        if (postfixExpression.equals("0")) return "0.0";

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < postfixExpression.length(); ++i) {
            char ch = postfixExpression.charAt(i);

//            if numeric then push to stack.
            if (Character.isLetterOrDigit(ch)) stack.push(String.valueOf(ch));

//            If not numeric then pop last two elements from stack
//            and perform operation on them
            if (!Character.isLetterOrDigit(ch)) {
                String aString = stack.pop();
                String bString = stack.pop();
                Double a = Double.parseDouble(aString);
                Double b = Double.parseDouble(bString);
                Double solution = 0.0;

                if (ch == '+') solution = b + a;
                if (ch == '-') solution = b - a;
                if (ch == '/') solution = b / a;
                if (ch == '*') solution = b * a;

                stack.push(String.valueOf(solution));
            }
        }

        return stack.peek();
    }

}
