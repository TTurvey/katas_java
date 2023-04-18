package org.example.fizzbuzz;

public class FizzBuzz {


    public String translate(int i) {
        if (i % 3 == 0) {
            return "Fizz";
        }
        if (i % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(i);
    }
}
