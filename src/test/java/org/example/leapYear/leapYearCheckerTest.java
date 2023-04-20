package org.example.leapYear;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class leapYearCheckerTest {

    @Test
    public void
    returns_false_if_year_is_not_divisible_by_4() {
        LeapYearChecker leapYearChecker = new LeapYearChecker();
        assertFalse(leapYearChecker.evaluate(3));
    }

}