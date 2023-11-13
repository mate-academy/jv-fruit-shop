package core.basesyntax.service.implementation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategyService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyServiceImpl implements OperationStrategyService {
    private final Map<FruitTransaction.Operation, OperationStrategy> operationStrategyMap;

    public OperationStrategyServiceImpl(Map<FruitTransaction.Operation,
            OperationStrategy> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public void applyOperationStrategy(FruitTransaction fruitTransaction) {
        FruitTransaction.Operation operation = fruitTransaction.getOperation();
        if (operation == null || operationStrategyMap.get(operation) == null) {
            throw new RuntimeException("Invalid input operation");
        }
        OperationStrategy strategy = operationStrategyMap.get(operation);
        strategy.apply(fruitTransaction);
    }
}
