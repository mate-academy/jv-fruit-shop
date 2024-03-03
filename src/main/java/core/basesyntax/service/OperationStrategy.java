package core.basesyntax.service;

import core.basesyntax.entity.Operation;
import core.basesyntax.service.quantity.handlers.OperationHandler;

public interface OperationStrategy {

    OperationHandler operate(Operation operation);
}
