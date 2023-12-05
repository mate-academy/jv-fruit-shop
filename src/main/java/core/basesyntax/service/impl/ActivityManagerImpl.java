package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ActivityManager;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class ActivityManagerImpl implements ActivityManager {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public ActivityManagerImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public void activateManager(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(t -> operationHandlerMap.get(t.getOperation())
                .executeOperation(t));
    }
}
