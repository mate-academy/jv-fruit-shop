package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationActivities;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationActivities> operationActivitiesMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,OperationActivities>
                                         operationActivitiesMap) {
        this.operationActivitiesMap = operationActivitiesMap;
    }

    @Override
    public OperationActivities get(FruitTransaction.Operation operation) {
        return operationActivitiesMap.get(operation);
    }
}
