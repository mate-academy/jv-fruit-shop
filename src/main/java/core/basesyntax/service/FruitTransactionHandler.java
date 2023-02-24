package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface FruitTransactionHandler {
    void handle(FruitTransaction transaction);
}
