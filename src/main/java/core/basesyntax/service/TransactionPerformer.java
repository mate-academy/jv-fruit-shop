package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface TransactionPerformer {
    void performTransaction(FruitTransaction transaction);
}
