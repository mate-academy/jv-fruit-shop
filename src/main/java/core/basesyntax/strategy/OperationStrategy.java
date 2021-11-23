package core.basesyntax.strategy;

import core.basesyntax.services.OperationHandler;
import core.basesyntax.services.impl.AddOperationHandler;
import core.basesyntax.services.impl.PurchaseOperationHandler;

import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {
    private static final String BALANCE_OPERATION= "b";
    private static final String SUPPLY_OPERATION= "s";
    private static final String PURCHASE_OPERATION= "p";
    private static final String RETURN_OPERATION= "r";
    private final Map<String, OperationHandler> operationMap = new HashMap<>();

    public OperationStrategy() {
        OperationHandler addOperationHandler = new AddOperationHandler();
        OperationHandler purchaseOperationHandler = new PurchaseOperationHandler();
        operationMap.put(BALANCE_OPERATION, addOperationHandler);
        operationMap.put(SUPPLY_OPERATION, addOperationHandler);
        operationMap.put(PURCHASE_OPERATION, purchaseOperationHandler);
        operationMap.put(RETURN_OPERATION, addOperationHandler);
    }

    public OperationHandler getOperationHandler(String operation) {
        return operationMap.get(operation);
    }
}
