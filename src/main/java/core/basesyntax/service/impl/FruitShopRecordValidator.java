package core.basesyntax.service.impl;

import core.basesyntax.service.Validator;

public class FruitShopRecordValidator implements Validator {
    private static final String VALID_PATTERN = "[bspr],\\w+,\\d+";

    @Override
    public boolean isValid(String record) {
        if (record.matches(VALID_PATTERN)) {
            return true;
        }
        throw new RuntimeException("Invalid string " + record);
    }
}
