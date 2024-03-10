package core.basesyntax.service;

import core.basesyntax.model.Operation;
import core.basesyntax.service.operations.IOperationHandler;

public interface IOperationStrategy {
    IOperationHandler get(Operation operation);
}
