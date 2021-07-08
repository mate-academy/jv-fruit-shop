package core.basesyntax.service;

import core.basesyntax.service.operation.BalanceHandler;
import core.basesyntax.service.operation.IncreaseHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseHandler;
import java.util.HashMap;
import java.util.Map;

public class HandlersStorage {
    private final Map<String, OperationHandler> handlers = new HashMap<>();

    {
        handlers.put("b",new BalanceHandler());
        handlers.put("s",new IncreaseHandler());
        handlers.put("p",new PurchaseHandler());
        handlers.put("r",new IncreaseHandler());
    }

    public Map<String, OperationHandler> getHandlers() {
        return handlers;
    }
}
