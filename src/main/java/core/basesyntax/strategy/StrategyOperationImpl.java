package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.service.CalculateOperation;
import core.basesyntax.service.impl.BalanceOperationImpl;
import core.basesyntax.service.impl.PurchaseOperationImpl;
import core.basesyntax.service.impl.ReturnOperationImpl;
import core.basesyntax.service.impl.SupplyOperationImpl;

import java.util.HashMap;
import java.util.Map;

public class StrategyOperationImpl implements Strategy{
    private final StorageDao fruitStorageDao;
    private Map<String, CalculateOperation> operationHandlerMap;

    public StrategyOperationImpl(StorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    public Map<String, CalculateOperation> getMap() {
        Map<String, CalculateOperation> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("r", new ReturnOperationImpl(fruitStorageDao));
        operationHandlerMap.put("p", new PurchaseOperationImpl(fruitStorageDao));
        operationHandlerMap.put("b", new BalanceOperationImpl(fruitStorageDao));
        operationHandlerMap.put("s", new SupplyOperationImpl(fruitStorageDao));
        return operationHandlerMap;
    }

    @Override
    public CalculateOperation get(String operation) {
        return getMap().get(operation);
    }
}
