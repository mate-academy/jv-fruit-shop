package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.FruitOperationHandler;

public interface Strategy {
    FruitOperationHandler get(FruitTransaction.Operation operation);
}
