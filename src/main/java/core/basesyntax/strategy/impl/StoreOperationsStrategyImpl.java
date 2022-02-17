package core.basesyntax.strategy.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.strategy.StoreOperationsStrategy;
import java.util.Map;

public class StoreOperationsStrategyImpl implements StoreOperationsStrategy {
    private final Map<Operation, OperationHandler> dataHandlerMap;

    public StoreOperationsStrategyImpl(Map<Operation, OperationHandler> dataHandlerMap) {
        this.dataHandlerMap = dataHandlerMap;
    }

    @Override
    public OperationHandler process(Operation operation) {
        return dataHandlerMap.get(operation);
    }
}
    
