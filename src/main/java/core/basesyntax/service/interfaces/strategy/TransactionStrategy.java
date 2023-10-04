package core.basesyntax.service.interfaces.strategy;

import core.basesyntax.model.FruitTransaction;

public interface TransactionStrategy {
    TransactionHandler getTransaction(FruitTransaction.Operation type);

    void addToMap(FruitTransaction.Operation operation, TransactionHandler transactionHandler);
}
