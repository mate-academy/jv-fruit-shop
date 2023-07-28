package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitOperation;
import core.basesyntax.strategy.FruitStrategy;
import java.util.Map;

public class FruitStrategyImpl implements FruitStrategy {
    private Map<FruitTransaction.Operation, FruitOperation> fruitOperations;

    public FruitStrategyImpl(Map<FruitTransaction.Operation, FruitOperation> fruitOperations) {
        this.fruitOperations = fruitOperations;
    }

    @Override
    public void operate(FruitTransaction fruitTransaction) {
        FruitOperation fruitOperation = fruitOperations.get(fruitTransaction.getOperation());
        fruitOperation.fruitOperate(fruitTransaction);
    }
}
