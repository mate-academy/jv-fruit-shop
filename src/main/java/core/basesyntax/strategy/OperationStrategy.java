package core.basesyntax.strategy;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.strategy.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
