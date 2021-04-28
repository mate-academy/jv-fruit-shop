package fruitshop.service;

import fruitshop.service.operation.OperationHandler;
import fruitshop.service.operation.OperationType;

public interface FruitService {
    OperationHandler get(OperationType operationType);
}
