package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;

public interface OperationProcessor {
    void processOperation(Transaction fruitTransaction);
}
