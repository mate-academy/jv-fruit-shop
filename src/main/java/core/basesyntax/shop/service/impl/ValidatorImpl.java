package core.basesyntax.shop.service.impl;

import core.basesyntax.shop.service.Operations;
import core.basesyntax.shop.service.Validator;

public class ValidatorImpl implements Validator {

    @Override
    public boolean validate(String table) {
        if (table.matches("(?si)^type,fruit,quantity(?m)"
                + "(\\n[" + Operations.operationsString() + "],\\w+,\\d{1,4})+$")) {
            return true;
        }
        throw new RuntimeException("Corrupted file data");
    }
}
