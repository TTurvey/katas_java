package org.example.balancebrackets;

public class BalanceBrackets {

    public String execute(String input) {
        if (input == null || input.equals("")) return "";

        int openCount = 0;
        int additionalLeadingOpenTags = 0;

        for (char ch : input.toCharArray()) {
            if (ch == '>') {
                if (openCount == 0) {
                    additionalLeadingOpenTags++;
                } else {
                    openCount--;
                }
            } else {
                openCount++;
            }
        }
        String beginning = "<".repeat(additionalLeadingOpenTags);
        String ending = ">".repeat(openCount);
        return  beginning + input + ending;
    }
}
