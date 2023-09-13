package core.basesyntax.strategy.impl;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> map;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> map) {
        this.map = map;
    }

    @Override
    public OperationHandler getByOperation(FruitTransaction.Operation operation) {
        return map.get(operation);
    }
}
