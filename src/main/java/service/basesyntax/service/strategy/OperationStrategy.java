package service.basesyntax.service.strategy;

import service.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
