package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface FruitTransactionParser {
    FruitTransaction parseTransaction(String line);
}
