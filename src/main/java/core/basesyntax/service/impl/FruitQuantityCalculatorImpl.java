package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitQuantityCalculator;
import core.basesyntax.strategy.OperationHandlerStrategy;
import java.util.List;

public class FruitQuantityCalculatorImpl implements FruitQuantityCalculator {
    private final OperationHandlerStrategy operationHandlerStrategy;

    public FruitQuantityCalculatorImpl(OperationHandlerStrategy operationHandlerStrategy) {
        this.operationHandlerStrategy = operationHandlerStrategy;
    }

    @Override
    public void calculateQuantity(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(f -> operationHandlerStrategy
                        .getOperationStrategy(f.getOperation())
                        .calculateData(f));
    }
}
