package strategy;

import model.StoreOperation;
import strategy.handler.OperationHandler;

public interface StoreOperationStrategy {
    OperationHandler getOperation(StoreOperation storeOperation);
}
