package core.strategy;

import core.db.FruitTransaction;
import core.db.StorageServiceImpl;
import core.service.OperationHandler;
import core.service.impl.BalanceHandler;
import core.service.impl.PurchaseHandler;
import core.service.impl.ReturnHandler;
import core.service.impl.SupplyHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlers;

    public OperationStrategy() {
        handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE,
                new BalanceHandler(new StorageServiceImpl()));
        handlers.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseHandler(new StorageServiceImpl()));
        handlers.put(FruitTransaction.Operation.RETURN,
                new ReturnHandler(new StorageServiceImpl()));
        handlers.put(FruitTransaction.Operation.SUPPLY,
                new SupplyHandler(new StorageServiceImpl()));
    }

    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        return handlers.get(operation);
    }
}
