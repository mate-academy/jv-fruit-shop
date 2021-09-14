package core.basesyntax.service.impl;

import core.basesyntax.db.HandlerStorage;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.OperationHandlerService;
import core.basesyntax.strategy.OperationHandler;

public class OperationHandlerServiceImpl implements OperationHandlerService {
    private HandlerStorage handlerStorage;

    public OperationHandlerServiceImpl(HandlerStorage handlerStorage) {
        this.handlerStorage = handlerStorage;
    }

    public void changeAmount(FruitRecord record) {
        OperationHandler handler = handlerStorage.getHandlerMap().get(record.getOperation());
        handler.getChangedAmount(record);
    }
}
