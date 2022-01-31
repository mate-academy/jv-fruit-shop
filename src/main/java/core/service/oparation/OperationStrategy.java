package core.service.oparation;

import core.model.TypeOperations;

public interface OperationStrategy {
    OperationHandler get(TypeOperations typeOperations);
}
