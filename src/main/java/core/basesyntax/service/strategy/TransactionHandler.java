package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;

public interface TransactionHandler {
    boolean handleTransaction(FruitTransaction transaction);
}
