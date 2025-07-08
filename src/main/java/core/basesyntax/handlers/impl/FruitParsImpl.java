package core.basesyntax.handlers.impl;

import core.basesyntax.handlers.FruitPars;
import core.basesyntax.model.FruitTransaction;

public class FruitParsImpl implements FruitPars {
    @Override
    public FruitTransaction.Operation parse(String value) {
        return FruitTransaction.Operation.fromCode(value);
    }
}
