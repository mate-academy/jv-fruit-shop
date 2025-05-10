package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface TransactionHandler {
    void process(FruitTransaction transaction);
}
