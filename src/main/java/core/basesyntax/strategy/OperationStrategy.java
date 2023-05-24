package core.basesyntax.strategy;

import core.basesyntax.model.fruit.Operation;
import core.basesyntax.strategy.impl.BalanceHandler;
import core.basesyntax.strategy.impl.PurchaseHandler;
import core.basesyntax.strategy.impl.ReturnHandler;
import core.basesyntax.strategy.impl.SupplyHandler;
import java.util.Map;

public class OperationStrategy {
    private final Map<Operation, OperationHandler> operationHandlerMap;

    public OperationStrategy(Map<Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
        operationHandlerMap.put(Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnHandler());
    }

    public OperationHandler get(Operation type) {
        return operationHandlerMap.get(type);
    }
}
