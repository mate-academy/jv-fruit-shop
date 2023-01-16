package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationStrategyImpl;
import core.basesyntax.strategy.impl.ReturnOperationStrategyImpl;
import core.basesyntax.strategy.impl.SupplyOperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionHandler {
    private Map<Operation, OperationStrategy> operationOperationStrategies;

    public TransactionHandler() {
        operationOperationStrategies = new HashMap<>();
        operationOperationStrategies.put(Operation.BALANCE, new BalanceOperationStrategyImpl());
        operationOperationStrategies.put(Operation.PURCHASE, new PurchaseOperationStrategyImpl());
        operationOperationStrategies.put(Operation.RETURN, new ReturnOperationStrategyImpl());
        operationOperationStrategies.put(Operation.SUPPLY, new SupplyOperationStrategyImpl());
    }

    public void handle(Map<String, Integer> fruits,
                       List<FruitTransaction> fruitTransactionDtos) {
        fruitTransactionDtos.forEach(t -> {
            String fruitName = t.getFruit();
            int currentBalance = fruits.get(fruitName) == null ? 0 : fruits.get(fruitName);
            OperationStrategy operationStrategy =
                    operationOperationStrategies.get(Operation.getOperation(t.getOperation()));
            Integer newBalance = operationStrategy.execute(currentBalance, t.getQuantity());
            fruits.put(fruitName, newBalance);
        });
    }
}
