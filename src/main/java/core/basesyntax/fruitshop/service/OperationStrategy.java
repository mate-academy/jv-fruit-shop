package core.basesyntax.fruitshop.service;

import core.basesyntax.fruitshop.model.OperationType;
import core.basesyntax.fruitshop.service.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(OperationType operationType);
}
