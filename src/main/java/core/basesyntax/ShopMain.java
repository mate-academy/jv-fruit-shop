package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.OperationProcessingStrategy;
import core.basesyntax.service.impl.OperationProcessingStrategyImpl;
import core.basesyntax.strategy.TransactionsHandling;
import core.basesyntax.strategy.impl.BalanceHandlingImpl;
import core.basesyntax.strategy.impl.PurchaseHandlingImpl;
import core.basesyntax.strategy.impl.ReturnHandlingImpl;
import core.basesyntax.strategy.impl.SupplyHandlingImpl;

import java.util.HashMap;
import java.util.Map;

public class ShopMain {
    private static final String FROM_FILE = "src/main/resources/daily_transaction.csv";
    private static final String TO_FILE = "src/main/resources/daily_report.csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        Map<Transaction.Operation, TransactionsHandling> strategy =
                new HashMap<>();
        strategy.put(Transaction.Operation.BALANCE, new BalanceHandlingImpl(storageDao));
        strategy.put(Transaction.Operation.SUPPLY, new SupplyHandlingImpl(storageDao));
        strategy.put(Transaction.Operation.PURCHASE, new PurchaseHandlingImpl(storageDao));
        strategy.put(Transaction.Operation.RETURN, new ReturnHandlingImpl(storageDao));
        OperationProcessingStrategy operationProcessingStrategy =
                new OperationProcessingStrategyImpl(strategy);
    }
}
