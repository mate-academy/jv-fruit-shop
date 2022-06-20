package core.basesyntax.service.impl;

import core.basesyntax.model.OperationWithFruit;
import core.basesyntax.service.Operation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandlerImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandlerImpl;
import core.basesyntax.strategy.impl.ReturnOperationHandlerImpl;
import core.basesyntax.strategy.impl.SupplyOperationHandlerImpl;
import java.util.HashMap;
import java.util.Map;

public class OperationImpl implements Operation {
    private final Map<OperationWithFruit, OperationHandler> handlerMap;

    public OperationImpl(Map<OperationWithFruit, OperationHandler> openFilesHandlerMap) {
        handlerMap = new HashMap<>();
        handlerMap.put(OperationWithFruit.BALANCE, new BalanceOperationHandlerImpl());
        handlerMap.put(OperationWithFruit.PURCHASE, new PurchaseOperationHandlerImpl());
        handlerMap.put(OperationWithFruit.SUPPLY, new SupplyOperationHandlerImpl());
        handlerMap.put(OperationWithFruit.RETURN, new ReturnOperationHandlerImpl());
    }

    @Override
    public OperationHandler getOperationHandler(OperationWithFruit operation) {
        return handlerMap.get(operation);
    }
}
