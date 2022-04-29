package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import java.util.HashMap;
import java.util.Map;

public class Strategy {
    private final StorageDao fruitStorageDao;

    public Strategy(StorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    public Map<String, OperationHandler> getMap() {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("r", new SupplyHandlerImpl(fruitStorageDao));
        operationHandlerMap.put("p", new PurchaseHandlerImpl(fruitStorageDao));
        operationHandlerMap.put("b", new BalanceHandler(fruitStorageDao));
        operationHandlerMap.put("s", new ReturnHandlerImpl(fruitStorageDao));
        return operationHandlerMap;
    }

    public OperationHandler get(String operation) {
        return getMap().get(operation);
    }
}
