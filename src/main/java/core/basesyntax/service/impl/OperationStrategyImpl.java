package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.strategy.BalanceHandler;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.PurchaseHandler;
import core.basesyntax.service.strategy.ReturnHandler;
import core.basesyntax.service.strategy.SupplyHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Fruit.Operation,OperationHandler> operationHandlerMap;

    public OperationStrategyImpl() {
        this.operationHandlerMap = initializeHandlers();
    }

    private Map<Fruit.Operation, OperationHandler> initializeHandlers() {
        Map<Fruit.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(Fruit.Operation.BALANCE, new BalanceHandler());
        handlers.put(Fruit.Operation.SUPPLY, new SupplyHandler());
        handlers.put(Fruit.Operation.PURCHASE, new PurchaseHandler());
        handlers.put(Fruit.Operation.RETURN, new ReturnHandler());
        return handlers;
    }

    @Override
    public OperationHandler get(Fruit.Operation type) {
        OperationHandler handler = operationHandlerMap.get(type);
        if (handler == null) {
            throw new IllegalArgumentException("Unsupported operation type: " + type);
        }
        return handler;
    }
}
