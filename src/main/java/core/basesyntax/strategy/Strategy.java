package core.basesyntax.strategy;

import core.basesyntax.service.impl.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;

public interface Strategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
