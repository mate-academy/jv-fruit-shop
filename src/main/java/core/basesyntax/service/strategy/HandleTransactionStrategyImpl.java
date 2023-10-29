package core.basesyntax.service.strategy;

import core.basesyntax.db.StorageDao;
import core.basesyntax.db.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.handlers.BalanceHandler;
import core.basesyntax.service.strategy.handlers.PurchaseHandler;
import core.basesyntax.service.strategy.handlers.ReturnHandler;
import core.basesyntax.service.strategy.handlers.SupplyHandler;
import java.util.HashMap;
import java.util.Map;

public class HandleTransactionStrategyImpl implements HandleTransactionStrategy {
    private static final Map<FruitTransaction.Operation, TransactionHandler>
            operationHandlerMap = new HashMap<>();
    private static final StorageDao storageDao = new StorageDaoImpl();

    public HandleTransactionStrategyImpl() {
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler(storageDao));
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler(storageDao));
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler(storageDao));
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseHandler(storageDao));
    }

    @Override
    public TransactionHandler get(FruitTransaction.Operation type) {
        return operationHandlerMap.get(type);
    }
}
