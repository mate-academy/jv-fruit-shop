package core.basesyntax.strategy.impl;

import java.util.Map;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataHandler;
import core.basesyntax.strategy.StoreOperationsStrategy;

public class StoreOperationsStrategyImpl implements StoreOperationsStrategy {

    private final Map<FruitTransaction.Operation, DataHandler> dataHandlerMap;

    public StoreOperationsStrategyImpl(Map<FruitTransaction.Operation, DataHandler> dataHandlerMap) {
        this.dataHandlerMap = dataHandlerMap;
    }

    @Override
    public DataHandler process(FruitTransaction.Operation operation) {
        return dataHandlerMap.get(operation);
    }
}
    
