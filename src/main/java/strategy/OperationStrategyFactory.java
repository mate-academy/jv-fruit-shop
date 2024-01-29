package strategy;

import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;

public class OperationStrategyFactory {
    private final Map<FruitTransaction.Operation, OperationStrategy> strategies;

    public OperationStrategyFactory() {
        strategies = new HashMap<>();
        strategies.put(FruitTransaction.Operation.BALANCE, new BalanceOperationStrategy());
        strategies.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationStrategy());
        strategies.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationStrategy());
        strategies.put(FruitTransaction.Operation.RETURN, new ReturnOperationStrategy());
    }

    public OperationStrategy getStrategy(FruitTransaction.Operation operation) {
        return strategies.get(operation);
    }
}
