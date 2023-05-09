package org.example.arithmetics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticsTest {

    @Test
    public void
    returns_string_with_whitespace_removed() {
        Arithmetics arithmetics = new Arithmetics();

        String input = "( ( 1 + 2 ) * ( 3 - 4 ) ) / 6";
        String expected = "((1+2)*(3-4))/6";
        String actual = arithmetics.removeWhitespace(input);

        assertEquals(expected, actual);
    }


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


    @ParameterizedTest
    @CsvSource({
            "(",
            ")",
            "())",
            "(()",
            "(1+(2-1)()"
    })
    public void
    returns_invalid_record_exception_if_an_odd_number_of_parentheses(String input) {
        Arithmetics arithmetics = new Arithmetics();
        int parenthesesCount = arithmetics.countParentheses(input);

        Exception exception = assertThrows(InvalidRecordException.class, () -> {
            arithmetics.checkEvenParentheses(parenthesesCount);
        });
        String expectedMessage = "Invalid record error";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }


    @ParameterizedTest
    @CsvSource({
            "1+2, 12+",
            "3-4, 34-",
            "5/6, 56/",
            "7*8, 78*",
            "(1+((2+3)*(4*5))), 123+45**+",
            "((()())), 0"
    })
    public void
    converts_infix_to_postfix(String input, String expected) {
        Arithmetics arithmetics = new Arithmetics();
        String actualValue = arithmetics.convertToPostfix(input);

        assertEquals(expected, actualValue);
    }


    @Test
    public void
    returns_true_if_string_is_numeric() {
        Arithmetics arithmetics = new Arithmetics();
        String input = "10";

        assertTrue(arithmetics.isNumeric(input));
    }


    @Test
    public void
    returns_false_if_string_is_not_numeric() {
        Arithmetics arithmetics = new Arithmetics();
        String input = "+";

        assertFalse(arithmetics.isNumeric(input));
    }


    @ParameterizedTest
    @CsvSource({
            "12+, 3.0",
            "34-, -1.0",
            "42/, 2.0",
            "78*, 56.0",
            "123+45**+, 101.0"
    })
    public void solve_postfix_expression(String input, String expected) {
        Arithmetics arithmetics = new Arithmetics();
        String actualValue = arithmetics.solvePostfix(input);

        assertEquals(expected, actualValue);
    }


    @ParameterizedTest
    @CsvSource({
            "( 1 + ( ( 2 + 3 ) * (4 * 5) ) ), 101.0",
            "( 5 * ( 4 * ( 3 * ( 2 * ( 1 * 9 ) / 8 - 7 ) + 6 ) ) ), -165.0",
            "((()())), 0.0"
    })
    public void solves_arithmetic_expressions(String input, String expected) throws InvalidRecordException{
        Arithmetics arithmetics = new Arithmetics();
        String actual = arithmetics.execute(input);

        assertEquals(expected, actual);
    }




}
