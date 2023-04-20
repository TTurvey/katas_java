package org.example.leapYear;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class leapYearCheckerTest {

    @Test
    public void
    returns_false_if_year_is_not_divisible_by_4() {
        LeapYearChecker leapYearChecker = new LeapYearChecker();
        assertFalse(leapYearChecker.evaluate(1997));
    }

    @Test
    public void
    returns_true_if_year_is_divisible_by_4() {
        LeapYearChecker leapYearChecker = new LeapYearChecker();
        assertTrue(leapYearChecker.evaluate(1996));
    }

    @Test
    public void
    returns_true_if_year_is_divisible_by_400() {
        LeapYearChecker leapYearChecker = new LeapYearChecker();
        assertTrue(leapYearChecker.evaluate(1600));
    }

    @Test
    public void
    returns_false_if_year_is_divisible_by_100_but_not_by_400() {
        LeapYearChecker leapYearChecker = new LeapYearChecker();
        assertFalse(leapYearChecker.evaluate(1800));
    }

}
