package core.basesyntax.service.impl;

import core.basesyntax.db.StorageDao;
import core.basesyntax.db.StorageDaoImpl;
import core.basesyntax.models.Transaction;
import core.basesyntax.service.TransactionsCalculator;
import core.basesyntax.strategy.BalanceTransactionHandler;
import core.basesyntax.strategy.PurchaseTransactionHandler;
import core.basesyntax.strategy.ReturnTransactionHandler;
import core.basesyntax.strategy.SupplyTransactionHandler;
import core.basesyntax.strategy.TransactionHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionsCalculatorImpl implements TransactionsCalculator {
    private Map<String, TransactionHandler> transactionHandlerMap = new HashMap<>();

    {
        StorageDao storageDao = new StorageDaoImpl();
        transactionHandlerMap.put("b", new BalanceTransactionHandler(storageDao));
        transactionHandlerMap.put("s", new SupplyTransactionHandler(storageDao));
        transactionHandlerMap.put("r", new ReturnTransactionHandler(storageDao));
        transactionHandlerMap.put("p", new PurchaseTransactionHandler(storageDao));
    }

    public void handleTransactions(List<Transaction> transactionsList) {
        for (Transaction transaction: transactionsList) {
            transactionHandlerMap.get(transaction.getType()).handleTransaction(transaction);
        }
    }
}
