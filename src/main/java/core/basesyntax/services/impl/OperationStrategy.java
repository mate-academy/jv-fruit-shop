package core.basesyntax.services.impl;

import core.basesyntax.services.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {
    private final Map<String, OperationHandler> operationMap = new HashMap<>();

    public OperationStrategy() {
        OperationHandler addOperationHandler = new AddOperationHandler();
        OperationHandler purchaseOperationHandler = new PurchaseOperationHandler();
        operationMap.put("b", addOperationHandler);
        operationMap.put("s", addOperationHandler);
        operationMap.put("p", purchaseOperationHandler);
        operationMap.put("r", addOperationHandler);
    }

    public OperationHandler getOperationHandler(String operation) {
        return operationMap.get(operation);
    }
}
