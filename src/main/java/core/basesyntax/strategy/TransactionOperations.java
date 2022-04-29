package core.basesyntax.strategy;

import core.basesyntax.models.Transaction;
import core.basesyntax.strategy.implementation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionOperations {
    static Map<String, TransactionHandler> transactionHandlerMap = new HashMap<>();

    public void handleTransactions(List<Transaction> transactionsList) {
        transactionHandlerMap.put("b", new BalanceTransaction());
        transactionHandlerMap.put("s", new SupplyTransaction());
        transactionHandlerMap.put("r", new ReturnTransaction());
        transactionHandlerMap.put("p", new PurchaseTransaction());
        for (Transaction transaction: transactionsList) {
            transactionHandlerMap.get(transaction.getType()).handleTransaction(transaction);
        }
    }
}
