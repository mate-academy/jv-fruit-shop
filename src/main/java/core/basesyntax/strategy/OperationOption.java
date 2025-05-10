package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.operationhandlers.OperationsHandler;

public interface OperationOption {
    OperationsHandler getHandler(FruitTransaction fruitTransaction);
}
