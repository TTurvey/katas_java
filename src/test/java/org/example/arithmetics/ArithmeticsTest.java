package org.example.arithmetics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticsTest {

    @Test
    public void
    returns_invalid_record_error_if_not_all_wrapped_in_parentheses() {
        Arithmetics arithmetics = new Arithmetics();
        assertThrows(InvalidRecordException.class, () -> {
            arithmetics.execute("3 + ( 2 * 1 )");
        });
    }


}