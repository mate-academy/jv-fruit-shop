package core.basesyntax.service.impl;

import core.basesyntax.service.Validator;

public class ValidatorImpl implements Validator {
    @Override
    public void validate(String line) {
        if (!line.matches("[a-z],[a-z]+,[0-9]+")) {
            throw new RuntimeException("Invalid input format in line:" + line);
        }
    }
}
