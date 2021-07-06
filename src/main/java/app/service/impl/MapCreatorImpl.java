package app.service.impl;

import app.service.MapCreator;
import app.strategy.OperationHandler;
import app.strategy.impl.AddOperationHandler;
import app.strategy.impl.BalanceOperationHandler;
import app.strategy.impl.PurchaseOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class MapCreatorImpl implements MapCreator {

    @Override
    public Map<String, OperationHandler> createMap() {
        Map<String, OperationHandler> handlers = new HashMap<>();
        handlers.put("b", new BalanceOperationHandler());
        handlers.put("p", new PurchaseOperationHandler());
        handlers.put("r", new AddOperationHandler());
        handlers.put("s", new AddOperationHandler());
        return handlers;
    }
}
