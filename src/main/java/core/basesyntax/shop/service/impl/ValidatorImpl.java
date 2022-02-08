package core.basesyntax.shop.service.impl;

import static core.basesyntax.shop.service.Operations.operationsString;

import core.basesyntax.shop.service.Validator;

public class ValidatorImpl implements Validator {

    @Override
    public boolean validate(String table) {
        if (table.matches("(?si)^type,fruit,quantity(?m)"
                + "(\\n[" + operationsString() + "],\\w+,\\d{1,4})+$")) {
            return true;
        }
        throw new RuntimeException("Corrupted file data");
    }
}
