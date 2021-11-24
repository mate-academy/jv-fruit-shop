package core.basesyntax.strategy;

import core.basesyntax.services.OperationHandler;
import core.basesyntax.services.impl.AddOperationHandler;
import core.basesyntax.services.impl.PurchaseOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<String, OperationHandler> operationMap = new HashMap<>();

    public OperationStrategyImpl() {
        OperationHandler addOperationHandler = new AddOperationHandler();
        OperationHandler purchaseOperationHandler = new PurchaseOperationHandler();
        operationMap.put(OperationType.BALANCE.getValue(), addOperationHandler);
        operationMap.put(OperationType.SUPPLY.getValue(), addOperationHandler);
        operationMap.put(OperationType.PURCHASE.getValue(), purchaseOperationHandler);
        operationMap.put(OperationType.RETURN.getValue(), addOperationHandler);
    }

    public OperationHandler getOperationHandler(String operation) {
        return operationMap.get(operation);
    }
}
