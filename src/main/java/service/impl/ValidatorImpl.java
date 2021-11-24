package service.impl;

import service.Validator;

public class ValidatorImpl implements Validator {
    private static final String SEPARATOR = ",";
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public boolean validate(String line) {
        if (line.isBlank()) {
            throw new RuntimeException("Invalid File");
        }
        String [] split = line.split(SEPARATOR);
        int quantity;
        try {
            quantity = Integer.parseInt(split[INDEX_OF_QUANTITY]);
        } catch (RuntimeException e) {
            throw new RuntimeException("We can't use number", e);
        }
        try {
            if (quantity < 0 || split.length > 3) {
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("No valid line", e);
        }
        return true;
    }
}
