package org.example.arithmetics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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


    @ParameterizedTest
    @CsvSource({
            "1 + 2, 12+",
            "3 - 4, 34-",
            "5 / 6, 56/",
            "7 * 8, 78*",
            "( 1 + ( ( 2 + 3 ) * (4 * 5) ) ), 123+45**+"
    })
    public void converts_infix_to_postfix(String input, String output) {
        Arithmetics arithmetics = new Arithmetics();
        String actualValue = arithmetics.convertToPostfix(input);

        assertEquals(output, actualValue);
    }

    @Test
    public void
    returns_string_with_whitespace_removed() {
        Arithmetics arithmetics = new Arithmetics();

        String input = "( ( 1 + 2 ) * ( 3 - 4 ) ) / 6";
        String expected = "((1+2)*(3-4))/6";
        String actual = arithmetics.removeWhitespace(input);

        assertEquals(expected, actual);
    }



}
