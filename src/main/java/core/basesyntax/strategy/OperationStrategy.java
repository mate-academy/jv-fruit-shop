package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    TransactionProcessor getTransactionProcessor(FruitTransaction.Operation operation);
}
