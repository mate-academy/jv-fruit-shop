package core.basesyntax.service.impl;

import core.basesyntax.service.ValidatorService;

public class ValidatorServiceImpl implements ValidatorService {
    private static final String RECORD_REGEX = "[bspr],[a-zA-Z]+,[0-9]+";
    private static final int NUMBER_OF_PARTS = 3;

    @Override
    public boolean validate(String line) {
        return line.split(",").length == NUMBER_OF_PARTS && line.matches(RECORD_REGEX);
    }
}
