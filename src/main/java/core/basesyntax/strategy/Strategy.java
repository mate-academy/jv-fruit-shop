package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;

public interface Strategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
