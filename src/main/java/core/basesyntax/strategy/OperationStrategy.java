package core.basesyntax.strategy;

import core.basesyntax.model.FruitOperation;
import core.basesyntax.strategy.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitOperation.Operation type);
}
