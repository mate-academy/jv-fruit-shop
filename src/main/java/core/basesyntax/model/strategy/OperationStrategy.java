package core.basesyntax.model.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.strategy.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
