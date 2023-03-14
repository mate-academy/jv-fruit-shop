package strategy.impl;

import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;
import strategy.OperationHandler;
import strategy.OperatorStrategy;

public class OperatorStrategyImpl implements OperatorStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperatorStrategyImpl() {
        operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
    }

    public Map<FruitTransaction.Operation, OperationHandler> getOperationHandlerMap() {
        return operationHandlerMap;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction transaction) {
        return operationHandlerMap.get(transaction.getOperation());
    }
}
