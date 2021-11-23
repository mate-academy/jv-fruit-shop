package service.impl;

import service.Validator;

public class ValidatorImpl implements Validator {
    @Override
    public boolean validate(String line) {
        if (line.isEmpty()) {
            throw new RuntimeException("File is empty");
        }
        String [] split = line.split(",");
        int quantity;
        try {
            quantity = Integer.parseInt(split[2]);
        } catch (RuntimeException e) {
            throw new RuntimeException("Can't parse");
        }
        if (quantity < 0 || split.length > 3) {
            throw new RuntimeException("No valid line");
        }
        return true;
    }
}
