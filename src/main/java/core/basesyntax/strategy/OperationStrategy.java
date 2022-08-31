package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operations.TransactionHandle;

public interface OperationStrategy {
    TransactionHandle getByOperation(FruitTransaction.Operation operation);
}
