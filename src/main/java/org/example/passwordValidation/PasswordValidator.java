package org.example.passwordValidation;

interface PasswordValidator {

    Boolean checkPassword(String input);

    Boolean checkLength(String input);

    Boolean checkUppercase(String input);

    Boolean checkLowercase(String input);

    Boolean checkNumber(String input);

    Boolean checkUnderscore(String input);



}
