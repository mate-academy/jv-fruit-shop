package core.basesyntax.handlers;

import core.basesyntax.model.FruitTransaction;

public interface TransactionHandler {
    void handle(FruitTransaction transaction);
}
