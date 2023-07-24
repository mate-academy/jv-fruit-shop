package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.handlers.BalanceOperationHandler;
import core.basesyntax.strategy.handlers.OperationHandler;
import core.basesyntax.strategy.handlers.PurchaseOperationHandler;
import core.basesyntax.strategy.handlers.ReturnOperationHandler;
import core.basesyntax.strategy.handlers.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> operationHandlersMap = new HashMap<>();
    private final Map<String, OperationHandler> typeHandlersMap = new HashMap<>();

    {
        operationHandlersMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationHandlersMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlersMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlersMap.put(Operation.RETURN, new ReturnOperationHandler());
        typeHandlersMap.put("b", new BalanceOperationHandler());
        typeHandlersMap.put("s", new SupplyOperationHandler());
        typeHandlersMap.put("p", new PurchaseOperationHandler());
        typeHandlersMap.put("r", new ReturnOperationHandler());
    }

    @Override
    public OperationHandler get(Operation operation) {
        return operationHandlersMap.get(operation);
    }

    @Override
    public OperationHandler get(String type) {
        return typeHandlersMap.get(type);
    }
}
