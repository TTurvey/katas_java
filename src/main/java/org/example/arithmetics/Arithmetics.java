package org.example.arithmetics;

public class Arithmetics {

    public int execute(String input) throws InvalidRecordException {
        char[] arr = input.toCharArray();

        if (arr[0] != '(') throw new InvalidRecordException("Invalid record error");

        int parentheses = 0;
        for (char c : arr) {
            if (c == '(' || c == ')') parentheses ++;
        }

        if (parentheses % 2 != 0) throw new InvalidRecordException("Invalid record error");

        else {
            return 0;
        }
    }

}
