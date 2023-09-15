package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.operation.OperationHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> performingOperationMap;

    public OperationStrategyImpl(HashMap<FruitTransaction.Operation,
            OperationHandler> performingOperationMap) {
        this.performingOperationMap = performingOperationMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation code) {
        return performingOperationMap.get(code);
    }
}
