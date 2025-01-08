package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.impl.OperationHandler;

public interface OperationStrategy {
    OperationHandler getService(FruitTransaction.Operation fo);
}
