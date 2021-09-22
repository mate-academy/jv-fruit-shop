package core.service.strategy;

import core.exception.ValidationException;
import core.model.OperationType;
import core.service.operation.OperationTypeHandler;

public interface OperationTypeStrategy {
    OperationTypeHandler getHandle(OperationType operationType) throws ValidationException;
}
