package core.basesyntax.servise;

import core.basesyntax.model.Operation;
import core.basesyntax.servise.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Operation operation);
}
