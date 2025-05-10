package core.basesyntax.strategy;

import core.basesyntax.operation.OperationHandler;
import core.basesyntax.transaction.FruitTransaction;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
