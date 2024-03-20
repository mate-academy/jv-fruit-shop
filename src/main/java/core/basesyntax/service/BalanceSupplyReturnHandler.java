package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.strategy.BalanceSupplyStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.ReturnStrategy;
import java.util.HashMap;
import java.util.Map;

public class BalanceSupplyReturnHandler implements OperationHandler {
    private final Map<String, Integer> fruitStore;
    private final Map<Operation, OperationStrategy> operationStrategies;

    public BalanceSupplyReturnHandler(Map<String, Integer> fruitStore) {
        this.fruitStore = fruitStore;
        this.operationStrategies = new HashMap<>();
        operationStrategies.put(Operation.BALANCE, new BalanceSupplyStrategy());
        operationStrategies.put(Operation.SUPPLY, new BalanceSupplyStrategy());
        operationStrategies.put(Operation.RETURN, new ReturnStrategy());
    }

    @Override
    public void handleTransaction(FruitTransaction transaction) {
        OperationStrategy strategy = operationStrategies.get(transaction.getOperation());
        if (strategy == null) {
            throw new RuntimeException("Invalid operation: " + transaction.getOperation());
        }
        strategy.handleTransaction(transaction, fruitStore);
    }
}
