package core.strategy;

import core.db.FruitTransaction;
import core.service.OperationHandler;
import core.service.impl.BalanceHandler;
import core.service.impl.PurchaseHandler;
import core.service.impl.ReturnHandler;
import core.service.impl.SupplyHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();

    public OperationStrategy() {
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
    }

    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        return handlers.get(operation);
    }
}
