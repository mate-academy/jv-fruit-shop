package basesyntax.strategy;

import basesyntax.model.FruitTransaction;
import basesyntax.service.OperationHandler;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
