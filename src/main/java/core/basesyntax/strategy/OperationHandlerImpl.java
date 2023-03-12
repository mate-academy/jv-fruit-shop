package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationHandlerImpl implements OperationHandler {
    private Map<FruitTransaction.Operation, StoreActivities> storeActivitiesMap;

    public OperationHandlerImpl(Map<FruitTransaction.Operation,
            StoreActivities> storeActivitiesMap) {
        this.storeActivitiesMap = storeActivitiesMap;
    }

    @Override
    public StoreActivities getHandler(FruitTransaction.Operation operation) {
        return storeActivitiesMap.get(operation);
    }
}
