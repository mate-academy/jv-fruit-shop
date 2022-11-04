package core.basesyntax.strategy.impl;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.models.FruitTransaction;
import core.basesyntax.strategy.Strategy;
import java.util.HashMap;
import java.util.Map;

public class StrategyImpl implements Strategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationsMap = new HashMap<>();

    public StrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operationsMap) {
        this.operationsMap = operationsMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationsMap.get(operation);
    }
}
