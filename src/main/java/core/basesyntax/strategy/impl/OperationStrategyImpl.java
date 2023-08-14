package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationActivity;
import core.basesyntax.strategy.OperationStrategy;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationActivity> operationActivities;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,OperationActivity>
                                         operationActivities) {
        this.operationActivities = operationActivities;
    }

    @Override
    public OperationActivity get(FruitTransaction.Operation operation) {
        return operationActivities.get(operation);
    }
}
