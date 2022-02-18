package core.basesyntax.strategy;

import core.basesyntax.service.FruitTransaction.Operation;

public interface OperationStrategy {
    OperationHandler getStrategy(Operation operation);
}
