package app.service.impl;

import app.service.LineValidator;

public class LineValidatorImpl implements LineValidator {
    private static final String SEPARATOR = ",";
    private static final int WORDS_COUNT = 3;
    private static final int QUANTITY = 2;

    @Override
    public boolean isValid(String line) {
        if (line.length() > 0) {
            String[] data = line.split(SEPARATOR);
            if (data.length == WORDS_COUNT) {
                try {
                    Integer.parseInt(data[QUANTITY]);
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }
        return false;
    }
}
