package core.basesyntax.strategy.handler.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handler.OperationHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlerMap;

    public OperationStrategyImpl() {
        handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        handlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        handlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        handlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        return handlerMap.get(operation);
    }
}
