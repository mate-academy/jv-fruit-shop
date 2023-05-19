package core.basesyntax.service.transaction;

import core.basesyntax.model.FruitTransaction;

public interface TransactionHandler {
    void handle(FruitTransaction transaction);
}
