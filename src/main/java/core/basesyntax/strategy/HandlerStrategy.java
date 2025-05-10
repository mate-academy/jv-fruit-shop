package core.basesyntax.strategy;

import static core.basesyntax.model.Operation.BALANCE;
import static core.basesyntax.model.Operation.PURCHASE;
import static core.basesyntax.model.Operation.RETURN;
import static core.basesyntax.model.Operation.SUPPLY;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.handlers.BalanceHandler;
import core.basesyntax.strategy.handlers.PurchaseHandler;
import core.basesyntax.strategy.handlers.ReturnHandler;
import core.basesyntax.strategy.handlers.SupplyHandler;
import java.util.HashMap;
import java.util.Map;

public class HandlerStrategy {
    private static Map<Operation, OperationHandler> strategyMap;
    private final StorageDao storageDao;

    public HandlerStrategy(StorageDao storageDao) {
        this.storageDao = storageDao;
        HandlerStrategy.strategyMap = new HashMap<>();
    }

    public OperationHandler getHandlerByOperation(Operation operationType) {
        return strategyMap.get(operationType);
    }

    public void fillStrategyMap() {
        strategyMap.put(BALANCE, new BalanceHandler(storageDao));
        strategyMap.put(PURCHASE, new PurchaseHandler(storageDao));
        strategyMap.put(RETURN, new ReturnHandler(storageDao));
        strategyMap.put(SUPPLY, new SupplyHandler(storageDao));
    }
}
