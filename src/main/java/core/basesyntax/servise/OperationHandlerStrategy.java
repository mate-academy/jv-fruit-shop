package core.basesyntax.servise;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public interface OperationHandlerStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
