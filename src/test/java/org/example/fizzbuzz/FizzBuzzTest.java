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

    @Test
    public void should_return_Fizz_if_divisible_by_3(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        String result = fizzBuzz.translate(3);
        assertEquals("Fizz", result);
    }

    @Test
    public void should_return_Buzz_if_divisible_by_5(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        String result = fizzBuzz.translate(5);
        assertEquals("Buzz", result);
    }

    @Test
    public void should_return_FizzBuzz_if_divisible_by_3_and_5(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        String result = fizzBuzz.translate(15);
        assertEquals("FizzBuzz", result);
    }

    @Test
    public void should_call_translate_once_per_integer_in_range_from_1_to_input(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        String result = fizzBuzz.execute(15);
        String expected = "1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz";
        assertEquals(expected, result);
    }

}