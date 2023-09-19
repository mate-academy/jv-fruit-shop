package fruitshop.strategy;

import fruitshop.model.Operation;
import fruitshop.strategy.operation.OperationHandler;
import fruitshop.strategy.operation.impl.BalanceOperationHandler;
import fruitshop.strategy.operation.impl.PurchaseOperationHandler;
import fruitshop.strategy.operation.impl.ReturnOperationHandler;
import fruitshop.strategy.operation.impl.SupplyOperationHandler;

import java.util.Map;

public class OperationStrategy {
    private Map<Operation, OperationHandler> operationHandlerMap;

    public OperationStrategy(Map<Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    public OperationHandler getOperationHandler(Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
