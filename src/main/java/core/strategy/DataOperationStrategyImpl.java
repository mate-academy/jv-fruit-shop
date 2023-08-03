package core.strategy;

import core.service.OperationType;
import core.transactions.BalanceOperationHandler;
import core.transactions.OperationHandler;
import core.transactions.PurchaseOperationHandler;
import core.transactions.ReturnOperationHandler;
import core.transactions.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class DataOperationStrategyImpl implements DataOperationStrategy {
    @Override
    public Map<OperationType, OperationHandler> strategy() {
        Map<OperationType, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(OperationType.B, new BalanceOperationHandler());
        operationHandlers.put(OperationType.S, new SupplyOperationHandler());
        operationHandlers.put(OperationType.R, new ReturnOperationHandler());
        operationHandlers.put(OperationType.P, new PurchaseOperationHandler());
        return operationHandlers;
    }
}
