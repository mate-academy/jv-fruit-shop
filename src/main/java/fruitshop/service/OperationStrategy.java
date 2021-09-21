package fruitshop.service;

import fruitshop.model.OperationType;
import fruitshop.service.operations.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(OperationType operation);
}
