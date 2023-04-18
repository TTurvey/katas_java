package org.example.fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FizzBuzzTest {

    @Test
    public void should_return_input_if_not_divisible_by_3_or_5(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        String result = fizzBuzz.translate(1);
        assertEquals("1", result);
    }

}