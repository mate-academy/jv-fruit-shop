package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.StrategyOperation;
import java.util.HashMap;
import java.util.Map;

public class StrategyImpl implements Strategy {

    private final StorageDao storageDao;
    private Map<String, StrategyOperation> operationHandlerMap;

    public StrategyImpl(StorageDao fruitStorageDao) {
        this.storageDao = fruitStorageDao;
    }

    public Map<String, StrategyOperation> getMap() {
        Map<String, StrategyOperation> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("RETURN", new ReturnOperationImpl(storageDao));
        operationHandlerMap.put("PURCHASE", new PurchaseOperationImpl(storageDao));
        operationHandlerMap.put("BALANCE", new BalanceOperationImpl(storageDao));
        operationHandlerMap.put("SUPPLY", new SupplyOperationImpl(storageDao));
        return operationHandlerMap;
    }

    @Override
    public StrategyOperation get(String operation) {
        return getMap().get(operation);
    }
}
