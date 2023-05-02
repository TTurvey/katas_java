package org.example.arithmetics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticsTest {

    @Test
    public void
    returns_invalid_record_exception_if_not_all_wrapped_in_parentheses() {
        Arithmetics arithmetics = new Arithmetics();

        Exception exception = assertThrows(InvalidRecordException.class, () -> {
            arithmetics.execute("3 + ( 2 * 1 )");
        });
        String expectedMessage = "Invalid record error";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void
    returns_invalid_record_exception_if_an_odd_number_of_parentheses() {
        Arithmetics arithmetics = new Arithmetics();

        Exception exception = assertThrows(InvalidRecordException.class, () -> {
            arithmetics.execute("(3 + (( 2 * 1 ))");
        });
        String expectedMessage = "Invalid record error";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void
    returns_infix_to_postfix() {
        Arithmetics arithmetics = new Arithmetics();
        String infixExpression = "1+2";
        String postfixExpression = arithmetics.convertToPostfix(infixExpression);

        assertEquals("12+", postfixExpression);
    }
}
