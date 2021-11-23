package service.impl;

import service.Validator;

public class ValidatorImpl implements Validator {
    @Override
    public boolean validate(String line) {
        if (line.isBlank()) {
            throw new RuntimeException("Invalid File");
        }
        String [] split = line.split(",");
        int quantity;
        try {
            quantity = Integer.parseInt(split[2]);
        } catch (RuntimeException e) {
            throw new RuntimeException("We can use number");
        }
        if (quantity < 0 || split.length > 3) {
            throw new RuntimeException("No valid line");
        }
        return true;
    }
}
