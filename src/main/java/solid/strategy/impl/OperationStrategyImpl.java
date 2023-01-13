package solid.strategy.impl;

import java.util.HashMap;
import java.util.Map;
import solid.model.FruitTransaction;
import solid.strategy.OperationHandler;
import solid.strategy.OperationStrategy;
import solid.strategy.impl.operation.BalanceOperationHandler;
import solid.strategy.impl.operation.PurchaseOperationHandler;
import solid.strategy.impl.operation.ReturnOperationHandler;
import solid.strategy.impl.operation.SupplyOperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private static final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap =
            new HashMap<>();

    @Override
    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());
        return operationHandlerMap.get(operation);
    }
}
