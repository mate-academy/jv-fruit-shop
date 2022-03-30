package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitStorageDao;
import java.util.HashMap;
import java.util.Map;

public class OperationHandlerMapProvider {
    private final FruitStorageDao dao;

    public OperationHandlerMapProvider(FruitStorageDao dao) {
        this.dao = dao;
    }

    public Map<String, OperationHandler> getMap() {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("p", new PurchaseHandler(dao));
        operationHandlerMap.put("b", new BalanceHandler(dao));
        operationHandlerMap.put("r", new ReturnHandler(dao));
        operationHandlerMap.put("s", new SupplyHandler(dao));
        return operationHandlerMap;
    }
}
