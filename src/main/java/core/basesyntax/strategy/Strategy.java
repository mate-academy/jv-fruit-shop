package core.basesyntax.strategy;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.strategy.handlers.OperationHandler;

public interface Strategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
