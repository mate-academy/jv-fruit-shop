package fruit.shop.service;

import fruit.shop.model.FruitTransaction;
import fruit.shop.model.TransactionType;
import fruit.shop.service.transaction.BalanceTransactionHandler;
import fruit.shop.service.transaction.PurchaseTransactionHandler;
import fruit.shop.service.transaction.ReturnTransactionHandler;
import fruit.shop.service.transaction.SupplyTransactionHandler;
import fruit.shop.service.transaction.TransactionHandler;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final Map<TransactionType, TransactionHandler> transactionHandlerMap = Map.ofEntries(
            Map.entry(TransactionType.BALANCE, new BalanceTransactionHandler()),
            Map.entry(TransactionType.SUPPLY, new SupplyTransactionHandler()),
            Map.entry(TransactionType.PURCHASE, new PurchaseTransactionHandler()),
            Map.entry(TransactionType.RETURN, new ReturnTransactionHandler())
    );

    @Override
    public void executeTransactionHandler(FruitTransaction transaction) {
        transactionHandlerMap.get(transaction.getTransaction()).execute(transaction);
    }
}
