package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.operationhandler.BalanceHandler;
import core.basesyntax.operationhandler.OperationHandler;
import core.basesyntax.operationhandler.PurchaseHandler;
import core.basesyntax.operationhandler.ReturnHandler;
import core.basesyntax.operationhandler.SupplyHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {
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
