package fruit.shop.service.impl;

import fruit.shop.model.FruitTransaction;
import fruit.shop.service.TransactionHandler;
import fruit.shop.service.strategy.OperationHandler;
import fruit.shop.service.strategy.OperationStrategy;
import fruit.shop.service.strategy.impl.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class TransactionHandlerImpl implements TransactionHandler {
    private List<FruitTransaction> transactions;
    private OperationStrategy strategy;

    public TransactionHandlerImpl(List<FruitTransaction> transactions,
                                  Map<FruitTransaction.Operation, OperationHandler> fruitMap) {
        this.transactions = transactions;
        strategy = new OperationStrategyImpl(fruitMap);
    }

    public void getParsedStorage() {
        for (FruitTransaction transaction : transactions) {
            strategy.handleTransaction(transaction);
        }
    }
}
