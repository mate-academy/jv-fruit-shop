package core.basesyntax.strategy;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.impl.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.impl.BalanceTransactionHandler;
import core.basesyntax.strategy.impl.PurchaseTransactionHandler;
import core.basesyntax.strategy.impl.ReturnTransactionHandler;
import core.basesyntax.strategy.impl.SupplyTransactionHandler;
import java.util.HashMap;
import java.util.Map;

public class TransactionHandlerStrategy {
    private static final Map<FruitTransaction.Operation, TransactionHandler> handlersMap;
    private static final FruitStorageDao dao;

    static {
        dao = new FruitStorageDaoImpl();
        handlersMap = new HashMap<>();
        handlersMap.put(FruitTransaction.Operation.BALANCE, new BalanceTransactionHandler(dao));
        handlersMap.put(FruitTransaction.Operation.SUPPLY, new SupplyTransactionHandler(dao));
        handlersMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseTransactionHandler(dao));
        handlersMap.put(FruitTransaction.Operation.RETURN, new ReturnTransactionHandler(dao));
    }

    public TransactionHandler get(FruitTransaction.Operation operation) {
        return handlersMap.get(operation);
    }
}
