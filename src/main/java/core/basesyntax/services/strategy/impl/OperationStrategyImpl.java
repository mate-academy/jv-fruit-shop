package core.basesyntax.services.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.strategy.OperationHandler;
import core.basesyntax.services.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Type, OperationHandler> strategyOperations;

    public OperationStrategyImpl(Map<FruitTransaction.Type, OperationHandler> strategyOperations) {
        this.strategyOperations = strategyOperations;
    }

    @Override
    public OperationHandler get(FruitTransaction.Type type) {
        return strategyOperations.get(type);
    }
}
