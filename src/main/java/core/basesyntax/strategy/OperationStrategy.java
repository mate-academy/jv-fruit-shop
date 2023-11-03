package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.operationshandlers.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperationHandler(Operation operation);
}
