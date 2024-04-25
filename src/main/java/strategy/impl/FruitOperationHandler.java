package strategy.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import model.FruitOperationType;
import strategy.FruitOperationStrategy;

public class FruitOperationHandler {
    private final Map<FruitOperationType, FruitOperationStrategy> strategies;

    public FruitOperationHandler() {
        strategies = new HashMap<>();
        strategies.put(FruitOperationType.BALANCE, new BalanceOperation());
        strategies.put(FruitOperationType.SUPPLY, new SupplyOperation());
        strategies.put(FruitOperationType.PURCHASE, new PurchaseOperation());
        strategies.put(FruitOperationType.RETURN, new ReturnOperation());
    }

    public int executeOperation(FruitOperationType operationType, int currentValue, int value) {
        FruitOperationStrategy strategy = strategies.get(operationType);
        if (strategy == null) {
            throw new NoSuchElementException("OperationType " + operationType + " not found");
        }
        return strategy.execute(currentValue, value);
    }
}

