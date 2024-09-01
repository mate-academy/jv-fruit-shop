package core.basesyntax;

import core.basesyntax.Strategy.OperationHandler;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
