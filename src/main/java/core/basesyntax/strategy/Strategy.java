package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import java.util.HashMap;
import java.util.Map;

public class Strategy {
    private final StorageDao dao;
    private Map<String, OperationHandler> operationHandlerMap;

    public Strategy(StorageDao dao) {
        this.dao = dao;
        operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("r", new SupplyHandlerImpl(dao));
        operationHandlerMap.put("p", new PurchaseHandlerImpl(dao));
        operationHandlerMap.put("b", new BalanceHandler(dao));
        operationHandlerMap.put("s", new SupplyHandlerImpl(dao));
    }

    public Map<String, OperationHandler> getMap() {
        return operationHandlerMap;
    }

    public OperationHandler get(String operation) {
        return getMap().get(operation);
    }
}
