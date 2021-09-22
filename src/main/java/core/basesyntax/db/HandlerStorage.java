package core.basesyntax.db;

import core.basesyntax.model.Operation;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.Map;

public class HandlerStorage {
    private final Map<Operation, OperationHandler> handlerStorage;

    public HandlerStorage(Map<Operation, OperationHandler> handlerStorage) {
        this.handlerStorage = handlerStorage;
    }

    public Map<Operation, OperationHandler> getHandlerStorage() {
        return handlerStorage;
    }
}
