package core.basesyntax;

import core.basesyntax.strategy.OperationHandler;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
