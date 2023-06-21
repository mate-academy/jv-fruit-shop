package fruit.shop.service.impl;

import fruit.shop.model.FruitTransaction;
import fruit.shop.service.TransactionHandler;
import fruit.shop.service.strategy.OperationHandler;
import fruit.shop.service.strategy.OperationStrategy;
import java.util.List;

public class TransactionHandlerImpl implements TransactionHandler {
    private OperationStrategy strategy;

    public TransactionHandlerImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public void parseStorage(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = strategy.getOperationHandler(transaction);
            handler.handleTransaction(transaction);
        }
    }
}
