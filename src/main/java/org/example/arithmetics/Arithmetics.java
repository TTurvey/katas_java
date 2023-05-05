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

    public int execute(String input) throws InvalidRecordException {

        String[] arr = input.split(" ");
        ArrayList<String> strList = new ArrayList<>(Arrays.asList(arr));

        if (!strList.get(0).equals("(")) throw new InvalidRecordException("Invalid record error");

        //  count parentheses
        int parentheses = 0;
        for (String c : strList) {
            if (c.equals("(") || c.equals(")")) parentheses++;
        }

        if (parentheses % 2 != 0) throw new InvalidRecordException("Invalid record error");

        String postfixExpression = convertToPostfix(input);

        return 0;
    }

    public String convertToPostfix(String infixExpression) {
        if (infixExpression.contains(" ")){
            infixExpression = removeWhitespace(infixExpression);
        }

        // Initializing empty String for result
        String result = "";

        // Initializing empty stack.
        // Deque is an interface whereas Stack is a class.
        // Java supports the inheritance of multiple interfaces.
        // Java doesn't support multiple inheritance of classes.
        // Therefore, using Deque for a stack is more flexible.
        // Can also insert/remove from both ends unlike Stack.
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < infixExpression.length(); ++i) {
            char c = infixExpression.charAt(i);

            // If the scanned character is an operand, add it to output.
            if (Character.isLetterOrDigit(c)) {result += c;}

            // If the scanned character is an '(', push it to the stack.
            else if (c == '(') {stack.push(c);}

            // If the scanned character is an ')', pop and output from the stack until an '(' is encountered.
            else if (c == ')') {
                while (!stack.isEmpty()
                        && stack.peek() != '(') {
                    result += stack.peek();
                    stack.pop();
                }
                stack.pop();
            }

            // An operator is encountered
            else {
                while (!stack.isEmpty()
                        && Precedence(c) <= Precedence(stack.peek())) {
                    result += stack.peek();
                    stack.pop();
                }
                stack.push(c);
            }
        }

        // Pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result += stack.peek();
            stack.pop();
        }

        return result;
    }

    public String removeWhitespace(String string) {
        return string.replaceAll(" ", "");
    }

    public String solvePostfix(String postfixExpression) {

        String[] arr = postfixExpression.split("");
        System.out.println(Arrays.asList(arr));
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++){
//            if numeric then push to stack.
            if (isNumeric(arr[i])) {
                stack.push(arr[i]);
                System.out.println(stack.toString());
            }


//            If not numeric then pop last two elements from stack
//            and perform operation on them
            if (!isNumeric(arr[i])){
                String aString = stack.pop();
                String bString = stack.pop();
                Double a = Double.parseDouble(aString);
                Double b = Double.parseDouble(bString);
                Double c = 0.0;

                if (arr[i].equals("+")) {c =  b + a;}
                if (arr[i].equals("-")) {c =  b - a;}
                if (arr[i].equals("/")) {c =  b / a;}
                if (arr[i].equals("*")) {c =  b * a;}

                String cString = String.valueOf(c);
                stack.push(cString);
                System.out.println(stack.toString());
            }
        }
        String result = stack.peek();

        return result;
    }

    public boolean isNumeric(String input) {
        try {
            double d = Double.parseDouble(input);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }




}