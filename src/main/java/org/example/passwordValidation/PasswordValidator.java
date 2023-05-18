package org.example.passwordValidation;

// Implementations of interfaces methods in concrete classes should be annotated with @override.
// This is because it prevents simple mistakes from being made...

// If an interface method is not needed in the implementing class then it is usual to throw an exception instead.

// You can make the methods default in the interface itself since Java 8.
// If you have default methods in an interface it is not mandatory to override them in the implementing class.


interface PasswordValidator {

    Boolean checkPassword(String input);

    Boolean checkLength(String input);

    Boolean checkUppercase(String input);

    Boolean checkLowercase(String input);

    Boolean checkNumber(String input);

    Boolean checkUnderscore(String input);

}
