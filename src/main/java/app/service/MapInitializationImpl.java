package app.service;

import app.enums.OperationTypes;
import app.strategy.AddOperationHandler;
import app.strategy.BalanceOperationHandler;
import app.strategy.OperationHandler;
import app.strategy.PurchaseOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class MapInitializationImpl implements MapInitialization {
    @Override
    public Map<String, OperationHandler> createMap() {
        Map<String, OperationHandler> handlers = new HashMap<>();
        handlers.put(String.valueOf(OperationTypes.b), new BalanceOperationHandler());
        handlers.put(String.valueOf(OperationTypes.p), new PurchaseOperationHandler());
        handlers.put(String.valueOf(OperationTypes.r), new AddOperationHandler());
        handlers.put(String.valueOf(OperationTypes.s), new AddOperationHandler());
        return handlers;
    }
}
