package core.basesyntax.operationStrategy;

import core.basesyntax.Operation;
import core.basesyntax.operationHandler.*;

import java.util.HashMap;
import java.util.Map;

public class OperationStrategy{
    private final Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();

    public OperationStrategy() {
        operationHandlerMap.put(Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnHandler());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseHandler());
    }

    public OperationHandler getHandler(Operation operation) {
        return operationHandlerMap.get(operation);
    }
}


//OperationStrategy that should have a map of handlers, and should return a handler by operation type