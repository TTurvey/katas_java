package org.example.romanNumerals;

public class RomanNumerals {


    public String translate(int i) {
        String roman = "";
        while (i >= 1000) {
            roman += "M";
            i -= 1000;
        }
        if (i == 900) {
            roman += "CM";
            i -= 900;
        }
        while (i >= 500) {
            roman += "D";
            i -= 500;
        }
        if (i == 400) {
            roman += "CD";
            i -= 400;
        }
        while (i >= 100) {
            roman += "C";
            i -= 100;
        }
        if (i == 90) {
            roman += "XC";
            i -= 90;
        }
        if (i >= 50) {
            roman += "L";
            i -= 50;
        }
        if (i == 40) {
            roman += "XL";
            i -= 40;
        }
        while (i >= 10) {
            roman += "X";
            i -= 10;
        }
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
