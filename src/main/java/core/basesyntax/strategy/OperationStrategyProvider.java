package core.basesyntax.strategy;

import java.util.HashMap;
import java.util.Map;
import model.OperationType;

public class OperationStrategyProvider {
    private final Map<OperationType, OperationHandler> operationStrategy = new HashMap<>();

    public OperationStrategyProvider() {
        operationStrategy.put(OperationType.BALANCE, new BalanceOperationHandler());
        operationStrategy.put(OperationType.SUPPLY, new SupplyOperationHandler());
        operationStrategy.put(OperationType.PURCHASE, new PurchaseOperationHandler());
        operationStrategy.put(OperationType.RETURN, new ReturnOperationHandler());
    }

    public OperationHandler getHandler(OperationType operationType) {
        return operationStrategy.get(operationType);
    }

    public Map<OperationType, OperationHandler> getOperationStrategy() {
        return operationStrategy;
    }
}
