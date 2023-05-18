package org.example.PasswordValidation2;

final class LongerThan implements Rule {

    private final int size;

    public LongerThan(int size) {
        this.size = size;
    }

    @Override
    public boolean isPassedOn(String string) {
        return string.length() > size;
    }
}