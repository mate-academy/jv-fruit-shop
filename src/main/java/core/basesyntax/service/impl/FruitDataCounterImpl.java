package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitDataCounter;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.QuantityCalculationStrategy;
import java.util.List;
import java.util.Map;

public class FruitDataCounterImpl implements FruitDataCounter {
    private final Map<FruitTransaction.Operation, QuantityCalculationStrategy> operationsMap;

    public FruitDataCounterImpl(Map<FruitTransaction.Operation,
            QuantityCalculationStrategy> operationsMap) {
        this.operationsMap = operationsMap;
    }

    @Override
    public void fruitsCounter(List<FruitTransaction> fruitTransactions) {
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationsMap);
        for (FruitTransaction fruitTransaction: fruitTransactions) {
            QuantityCalculationStrategy strategy
                    = operationStrategy.get(fruitTransaction.getOperation());
            strategy.calculate(fruitTransaction);
        }
    }
}
