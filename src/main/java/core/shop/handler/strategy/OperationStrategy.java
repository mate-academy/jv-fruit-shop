package core.shop.handler.strategy;

import core.shop.handler.OperationHandler;
import core.shop.model.OperationType;

public interface OperationStrategy {
    OperationHandler getOperationHandler(OperationType operationType);
}
