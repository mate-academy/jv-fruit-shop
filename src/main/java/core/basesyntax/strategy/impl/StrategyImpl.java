package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.StrategyOperation;
import java.util.Map;

public class StrategyImpl implements Strategy {
    private final StorageDao storageDao;
    private Map<String, StrategyOperation> operationHandlerMap;

    public StrategyImpl(StorageDao fruitStorageDao,
                        Map<String, StrategyOperation> operationHandlerMap) {
        this.storageDao = fruitStorageDao;
        this.operationHandlerMap = operationHandlerMap;
    }

    public void handle(FruitTransaction fruitTransaction) {
        operationHandlerMap.get(fruitTransaction.getOperation().name())
                .handle(fruitTransaction);
    }
}
