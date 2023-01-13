package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.operations.OperationHandler;

public interface Strategy {
    OperationHandler getByOperation(Operation operation);
}
