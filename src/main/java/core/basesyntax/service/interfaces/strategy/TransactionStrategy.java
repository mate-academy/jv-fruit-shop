package core.basesyntax.service.interfaces.strategy;

import core.basesyntax.model.FruitTransaction;

public interface  TransactionStrategy {
    TransactionHandler getTransaction(FruitTransaction.Operation type);
}
