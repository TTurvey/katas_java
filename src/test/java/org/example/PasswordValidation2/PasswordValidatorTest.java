package org.example.PasswordValidation2;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    @Test
    public void with_no_rules_every_password_will_be_fine() {
        PasswordValidator pv = new PasswordValidator(new ArrayList<Rule>());
        assertTrue(pv.isAcceptable("everything_will_be_just_fine"));
    }

    @Test
    public void with_always_failing_rule_every_password_will_be_rejected() {
        PasswordValidator pv = new PasswordValidator(asList(string -> false));
        assertFalse(pv.isAcceptable("everything_will_be_rejected"));
    }

    @Test
    public void with_always_failing_rule_every_password_will_be_fine() {
        PasswordValidator pv = new PasswordValidator(asList(string -> true));
        assertTrue(pv.isAcceptable("everything_will_be_fine"));
    }

    @Test
    public void rule_is_evaluated() throws Exception {
        SpyRule rule = new SpyRule();
        PasswordValidator pv = new PasswordValidator(asList(rule));
        assertFalse(rule.hasBeenCalled);
        pv.isAcceptable("anything");
        assertTrue(rule.hasBeenCalled);
    }

    private final class SpyRule implements Rule {
        public boolean hasBeenCalled = false;

        @Override
        public boolean isPassedOn(String string) {
            this.hasBeenCalled = true;
            return true;
        }
    }


}