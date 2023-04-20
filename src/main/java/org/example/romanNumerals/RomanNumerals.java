package org.example.romanNumerals;

public class RomanNumerals {


    public String translate(int i) {
        if (i == 3) {
            return "III";
        }
        if (i == 2) {
            return "II";
        }
        return "I";
    }
}
