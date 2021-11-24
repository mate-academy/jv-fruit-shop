package core.basesyntax.service.impl;

import core.basesyntax.service.Validator;

public class ValidatorImpl implements Validator {
    @Override
    public boolean validate(String line) {
        String[] components = line.split(",");
        return components.length == 3 && components[0].matches("[bspr]")
                && Integer.parseInt(components[2]) >= 0;
    }
}
