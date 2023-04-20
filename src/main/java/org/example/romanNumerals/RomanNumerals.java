package org.example.romanNumerals;

public class RomanNumerals {


    public String translate(int i) {
        String roman = "";
        if (i == 9) {
            roman += "IX";
            i -= 9;
        }
        if (i >= 5) {
            roman += "V";
            i -= 5;
        }
        if (i == 4) {
            roman += "IV";
            i -= 4;
        }
        while (i > 0) {
            roman += "I";
            i -= 1;
        }
        return roman;
    }
}
