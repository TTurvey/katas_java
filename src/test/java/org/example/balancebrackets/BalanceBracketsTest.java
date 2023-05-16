package org.example.balancebrackets;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BalanceBracketsTest {

    @ParameterizedTest
    @CsvSource({
            "<, <>",
            "<<, <<>>",
            ">, <>",
            ">>, <<>>",
            "><<><, <><<><>>",
            "<><<, <><<>>",
            "<><<<>, <><<<>>>",
            "<><<<><, <><<<><>>>",
            "><<>, <><<>>",
            "><<<, <><<<>>>"
    })
    public void
    should_return_balanced_after_prepend_and_append(String input, String expected) {
        BalanceBrackets bb = new BalanceBrackets();
        String actual = bb.execute(input);

        assertEquals(expected, actual);
    }

    @Test
    public void
    should_return_empty_string() {
        BalanceBrackets bb = new BalanceBrackets();

        String actualEmpty = bb.execute("");
        assertEquals("", actualEmpty);

        String actualNull = bb.execute(null);
        assertEquals("", actualNull);
    }
}
