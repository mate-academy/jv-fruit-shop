package core.basesyntax.strategy;

import core.basesyntax.FruitTransaction;
import core.basesyntax.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
