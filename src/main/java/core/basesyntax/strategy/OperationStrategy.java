package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.amount.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperationImpl(Operation operation);
}
