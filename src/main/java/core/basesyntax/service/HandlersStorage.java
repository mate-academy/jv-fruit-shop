package core.basesyntax.service;

import core.basesyntax.service.operation.OperationBHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationPHandler;
import core.basesyntax.service.operation.OperationRHandler;
import core.basesyntax.service.operation.OperationSHandler;
import java.util.HashMap;
import java.util.Map;

public class HandlersStorage {
    private final Map<String, OperationHandler> handlers = new HashMap<>();

    {
        handlers.put("b",new OperationBHandler());
        handlers.put("s",new OperationSHandler());
        handlers.put("p",new OperationPHandler());
        handlers.put("r",new OperationRHandler());
    }

    public Map<String, OperationHandler> getHandlers() {
        return handlers;
    }
}
