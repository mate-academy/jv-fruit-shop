package core.basesyntax.strategy;

import core.basesyntax.model.OperationsWithFruits;
import core.basesyntax.operationshandlers.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperationHandler(OperationsWithFruits operation);
}
