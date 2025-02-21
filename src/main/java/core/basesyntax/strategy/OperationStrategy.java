package core.basesyntax.strategy;

import core.basesyntax.FruitTransaction;
import core.basesyntax.strategy.handlers.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation type);
}
