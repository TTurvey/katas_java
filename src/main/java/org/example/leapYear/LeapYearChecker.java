package org.example.leapYear;

public class LeapYearChecker {

    public boolean evaluate(int i) {
        if (i % 4 == 0) {
            return true;
        }
        if (i % 400 == 0) {
            return true;
        }
        return false;
    }
}
