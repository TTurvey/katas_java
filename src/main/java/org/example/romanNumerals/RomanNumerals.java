package org.example.romanNumerals;

public class RomanNumerals {


    public String translate(int i) {
        String roman = "";
        while (i > 0) {
            roman += "I";
            i -= 1;
        }
        return roman;
    }
}
