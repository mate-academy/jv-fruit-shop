package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransfer;
import core.basesyntax.operationhandler.OperationHandler;

public interface FruitOperationStrategy {
    OperationHandler get(FruitTransfer.Operation operation);
}
