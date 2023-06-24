package strategy;

import java.util.Map;
import model.StoreOperation;
import strategy.handler.OperationHandler;

public class StoreOperationStrategyImpl implements StoreOperationStrategy {
    private Map<StoreOperation, OperationHandler> operationHandlerMap;

    public StoreOperationStrategyImpl(Map<StoreOperation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler getOperation(StoreOperation storeOperation) {
        return operationHandlerMap.get(storeOperation);
    }
}
