package org.example.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {


    public String translate(int i) {
        if (i % 3 == 0 && i % 5 == 0) {
            return "FizzBuzz";
        }
        if (i % 3 == 0) {
            return "Fizz";
        }
        if (i % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(i);
    }


    public String execute(int number) {
        List<String> translations = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            translations.add(translate(i));
        }

        return String.join(", ", translations);
    }
}
