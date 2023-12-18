package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.ActivityHandler;
import core.basesyntax.strategy.ActivityStrategy;
import java.util.Map;

public class ActivityStrategyImpl implements ActivityStrategy {
    private Map<FruitTransaction.Operation, ActivityHandler> operationMap;

    public ActivityStrategyImpl(Map<FruitTransaction.Operation, ActivityHandler> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public ActivityHandler get(FruitTransaction.Operation operation) {
        return operationMap.get(operation);
    }
}
