package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.impl.BalanceHandler;
import core.basesyntax.service.impl.PurchaseHandler;
import core.basesyntax.service.impl.ReturnHandler;
import core.basesyntax.service.impl.SupplyHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {
    private final Map<String, OperationHandler> operationsList;

    public OperationStrategy(StorageDao<Fruit> storageDao) {
        operationsList = new HashMap<>();
        operationsList.put(OperationType.BALANCE.getName(), new BalanceHandler(storageDao));
        operationsList.put(OperationType.SUPPLY.getName(), new SupplyHandler(storageDao));
        operationsList.put(OperationType.PURCHASE.getName(), new PurchaseHandler(storageDao));
        operationsList.put(OperationType.RETURN.getName(), new ReturnHandler(storageDao));
    }

    public OperationHandler getService(String name) {
        return operationsList.get(name);
    }
}
