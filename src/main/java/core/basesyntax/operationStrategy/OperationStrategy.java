package core.basesyntax.operationStrategy;

import core.basesyntax.Operation;
import core.basesyntax.operationHandler.*;

import java.util.HashMap;
import java.util.Map;

public class OperationStrategy{
    private final Map<Operation, OperationHandler> operationHandlers;

    public OperationStrategy() {
        this.operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE, new BalanceHandler());
        operationHandlers.put(Operation.SUPPLY, new SupplyHandler());
        operationHandlers.put(Operation.PURCHASE, new PurchaseHandler());
        operationHandlers.put(Operation.RETURN, new ReturnHandler());
    }

    public OperationHandler getHandler(Operation operation) {
        return operationHandlers.get(operation);
    }}
