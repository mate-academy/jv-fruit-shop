package core.basesyntax.service.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationHandler;

public interface OperationStrategy {
    OperationHandler processOperation(Operation operation);
}
