package core.basesyntax.handlers;

import core.basesyntax.model.FruitTransaction;

public interface FruitPars {
    FruitTransaction.Operation parse(String value);
}

