package core.basesyntax.service.impl;

import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private final Map<String, OperationStrategy> operationStrategies;

    public FruitServiceImpl(Map<String, OperationStrategy> operationStrategies) {
        this.operationStrategies = operationStrategies;
    }

    @Override
    public void processTransaction(String[] transaction) {
        if (transaction[0].equalsIgnoreCase("type")) {
            return;
        }
        if (transaction.length < 3) {
            throw new IllegalArgumentException("Invalid transaction format.");
        }
        String operationType = transaction[0];
        if (!operationStrategies.containsKey(operationType)) {
            throw new IllegalArgumentException("Unknown operation type: " + operationType);
        }
        OperationStrategy strategy = operationStrategies.get(operationType);
        strategy.applyStrategy(transaction);
    }
}
