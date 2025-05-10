package strategy;

import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;
import strategy.operation.BalanceOperationHandler;
import strategy.operation.OperationHandler;
import strategy.operation.PurchaseOperationHandler;
import strategy.operation.ReturnOperationHandler;
import strategy.operation.SupplyOperationHandler;

public class OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> strategies;

    public OperationStrategy() {
        strategies = new HashMap<>();
        strategies.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        strategies.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        strategies.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        strategies.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
    }

    public OperationHandler getStrategy(FruitTransaction.Operation operation) {
        return strategies.get(operation);
    }
}
