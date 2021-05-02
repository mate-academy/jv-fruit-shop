package fruitshop.service;

import fruitshop.service.shopoperation.OperationHandler;
import fruitshop.service.shopoperation.OperationType;

public interface FruitService {
    OperationHandler getOperation(OperationType operationType);
}
