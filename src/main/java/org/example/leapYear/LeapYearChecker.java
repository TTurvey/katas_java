package org.example.leapYear;

public class LeapYearChecker {

    public boolean evaluate(int i) {
        if (i % 4 != 0) {
            return false;
        }
        return true;
    }
}
