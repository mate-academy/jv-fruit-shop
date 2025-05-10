package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.operation.OperationHandler;

public interface Strategy {
    OperationHandler get(Operation operation);
}
