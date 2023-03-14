package core.basesyntax.strategy;

import core.basesyntax.service.impl.FruitTransaction;

public class OperationStrategyImpl implements OperationStrategy {
    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return new StrategyStorage().getStrategy(operation.getCode());
    }
}
