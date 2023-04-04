package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.handlerfruits.FruitsHandler;
import java.util.Map;

public class OperationHandlerImp implements OperationHandler {
    private final Map<FruitTransaction.Operation, FruitsHandler> handlerMap;

    public OperationHandlerImp(Map<FruitTransaction
            .Operation, FruitsHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public FruitsHandler getEnum(FruitTransaction.Operation type) {
        return handlerMap.get(type);
    }
}
