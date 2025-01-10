package core.basesyntax.store.service.strategy;

import core.basesyntax.store.handler.OperationHandler;
import core.basesyntax.store.model.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
