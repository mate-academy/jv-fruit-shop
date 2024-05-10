package strategy;

import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;
import strategy.operation.BalanceOperationHandler;
import strategy.operation.OperationHandler;
import strategy.operation.PurchaseOperationHandler;
import strategy.operation.ReturnOperationHandler;
import strategy.operation.SupplyOperationHandler;

public class BalanceStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public BalanceStrategyImpl() {
        operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
    }

    @Override
    public OperationHandler getHandler(FruitTransaction fruitTransaction) {
        return operationHandlerMap.get(fruitTransaction.getOperation());
    }
}
