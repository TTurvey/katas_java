package org.example.PasswordValidation2;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {

    private List<Rule> rules;
    private static List<Rule> BASIC_RULES = asList(
            new ContainsDigits(),
            new ContainsAlphaChars(),
            new LongerThan(7),
            new ContainsUpperCaseChars()
    );

    public static PasswordValidator basic() {
        return build(false);
    }

    public static PasswordValidator forAdmin() {
        return build(true);
    }

    public PasswordValidator(List<Rule> rules) {
        this.rules = new ArrayList<Rule>(rules);
    }

    public boolean isAcceptable(String password) {
        return rules.stream().allMatch(rule -> rule.isPassedOn(password));
    }

    private static PasswordValidator build(boolean isAdmin) {
        List<Rule> rules = new ArrayList<Rule>(BASIC_RULES);
        if (isAdmin) {
            rules.addAll(asList(new LongerThan(10), new ContainsSpecialChars()));
        }
        return new PasswordValidator(rules);
    }

}