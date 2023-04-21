package org.example.arithmetics;

public class Arithmetics {

    public int execute(String input) throws InvalidRecordException {

        if (input.charAt(0) != '(') {
            throw new InvalidRecordException("Invalid record error");
        }
        else {
            return 0;
        }
    }

}
