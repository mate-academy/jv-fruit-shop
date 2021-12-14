package core.basesyntax.service;

import core.basesyntax.service.operation.BalanceHandler;
import core.basesyntax.service.operation.IncreaseHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {
    private final Map<String, OperationHandler> storageMap = new HashMap<>();

    {
        storageMap.put("b",new BalanceHandler());
        storageMap.put("s",new IncreaseHandler());
        storageMap.put("p",new PurchaseHandler());
        storageMap.put("r",new IncreaseHandler());
    }

    public Map<String, OperationHandler> getHandlers() {
        return storageMap;
    }
}
