package core.basesyntax.strategy.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.DataHandler;
import core.basesyntax.strategy.StoreOperationsStrategy;
import java.util.Map;

public class StoreOperationsStrategyImpl implements StoreOperationsStrategy {
    private final Map<Operation, DataHandler> dataHandlerMap;

    public StoreOperationsStrategyImpl(Map<Operation, DataHandler> dataHandlerMap) {
        this.dataHandlerMap = dataHandlerMap;
    }

    @Override
    public DataHandler process(Operation operation) {
        return dataHandlerMap.get(operation);
    }
}
    
