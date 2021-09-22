package core.basesyntax.service.impl;

import core.basesyntax.db.HandlerStorage;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.strategy.OperationHandler;

public class OperationServiceImpl implements OperationService {
    private final HandlerStorage handlerStorage;

    public OperationServiceImpl(HandlerStorage handlerStorage) {
        this.handlerStorage = handlerStorage;
    }

    public void setBalance(FruitRecord record) {
        OperationHandler handler = handlerStorage.getHandlerStorage().get(record.getOperation());
        handler.setBalance(record);
    }
}
