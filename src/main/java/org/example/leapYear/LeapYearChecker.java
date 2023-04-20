package org.example.leapYear;

public class LeapYearChecker {

    public boolean evaluate(int year) {
        return year % 4 == 0 && !(year % 100 == 0 && year % 400 != 0);
    }
}
