package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class ActivitiesStrategyImpl implements ActivitiesStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> activitiesHandlerMap;

    public ActivitiesStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> activitiesHandlerMap) {
        this.activitiesHandlerMap = activitiesHandlerMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return activitiesHandlerMap.get(operation);
    }
}

