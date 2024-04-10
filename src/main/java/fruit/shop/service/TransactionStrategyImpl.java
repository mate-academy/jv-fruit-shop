package fruit.shop.service;

import fruit.shop.model.FruitTransaction;
import fruit.shop.model.Transaction;
import fruit.shop.service.transaction.BalanceTransactionHandler;
import fruit.shop.service.transaction.PurchaseTransactionHandler;
import fruit.shop.service.transaction.ReturnTransactionHandler;
import fruit.shop.service.transaction.SupplyTransactionHandler;
import fruit.shop.service.transaction.TransactionHandler;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final Map<Transaction, TransactionHandler> transactionHandlerMap = Map.ofEntries(
            Map.entry(Transaction.BALANCE, new BalanceTransactionHandler()),
            Map.entry(Transaction.SUPPLY, new SupplyTransactionHandler()),
            Map.entry(Transaction.PURCHASE, new PurchaseTransactionHandler()),
            Map.entry(Transaction.RETURN, new ReturnTransactionHandler())
    );

    @Override
    public void executeTransactionHandler(FruitTransaction transaction) {
        transactionHandlerMap.get(transaction.getTransaction()).execute(transaction);
    }
}
