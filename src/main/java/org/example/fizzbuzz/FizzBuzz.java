package org.example.fizzbuzz;

public class FizzBuzz {


    public String translate(int i) {
        if (i % 3 == 0) {
            return "Fizz";
        }
        return String.valueOf(i);
    }
}
