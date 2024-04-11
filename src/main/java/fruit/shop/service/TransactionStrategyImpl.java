package fruit.shop.service;

import fruit.shop.model.FruitTransaction;
import fruit.shop.model.TransactionType;
import fruit.shop.service.transaction.TransactionHandler;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final Map<TransactionType, TransactionHandler> transactionHandlerMap;

    public TransactionStrategyImpl(Map<TransactionType, TransactionHandler> transactionHandlerMap) {
        this.transactionHandlerMap = transactionHandlerMap;
    }

    @Override
    public void executeTransaction(FruitTransaction transaction) {
        transactionHandlerMap.get(transaction.getTransaction()).execute(transaction);
    }
}
