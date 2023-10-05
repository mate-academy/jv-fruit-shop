package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> fruitsMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> fruitsMap) {
        this.fruitsMap = fruitsMap;
    }

    @Override
    public OperationHandler getOperationHandler(FruitTransaction.Operation operationType) {
        return fruitsMap.get(operationType);
    }
}
