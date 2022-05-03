package core.basesyntax.service.impl;

import core.basesyntax.models.Transaction;
import core.basesyntax.service.TransactionsCalculator;
import core.basesyntax.strategy.BalanceTransaction;
import core.basesyntax.strategy.PurchaseTransaction;
import core.basesyntax.strategy.ReturnTransaction;
import core.basesyntax.strategy.SupplyTransaction;
import core.basesyntax.strategy.TransactionHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionsCalculatorImpl implements TransactionsCalculator {

    public void handleTransactions(List<Transaction> transactionsList) {
        Map<String, TransactionHandler> transactionHandlerMap = new HashMap<>();
        transactionHandlerMap.put("b", new BalanceTransaction());
        transactionHandlerMap.put("s", new SupplyTransaction());
        transactionHandlerMap.put("r", new ReturnTransaction());
        transactionHandlerMap.put("p", new PurchaseTransaction());
        for (Transaction transaction: transactionsList) {
            transactionHandlerMap.get(transaction.getType()).handleTransaction(transaction);
        }
    }
}
