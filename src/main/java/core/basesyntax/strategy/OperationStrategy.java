package core.basesyntax.strategy;

import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {
    private final Map<String, OparationHandler> operationMap = new HashMap<>();

    public OperationStrategy() {
        OparationHandler addOperationHandler = new AddOperationHandlerImpl();
        OparationHandler purchaseOperationHandler = new PurchaseOperationHandlerImpl();
        operationMap.put("b", addOperationHandler);
        operationMap.put("s", addOperationHandler);
        operationMap.put("p", purchaseOperationHandler);
        operationMap.put("r", addOperationHandler);
    }

    public OparationHandler getOperationHandler(String operation) {
        return operationMap.get(operation);
    }
}
