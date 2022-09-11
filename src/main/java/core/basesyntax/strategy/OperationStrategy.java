package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;

public interface OperationStrategy {
    OperationProcessor get(Transaction.Operation fruitOperation);
}
