package service.impl;

import core.basesyntax.FruitTransaction;
import db.Storage;
import java.util.List;
import service.ShopService;
import strategy.OperationHandler;
import strategy.OperationStrategy;

public class ShopServiceImpl implements ShopService {
    private final Storage storage;
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(Storage storage, OperationStrategy operationStrategy) {
        this.storage = storage;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        if (fruitTransactions == null) {
            throw new RuntimeException("List of transaction can't be null.");
        }
        for (FruitTransaction transaction : fruitTransactions) {
            if (transaction == null || transaction.getOperation() == null) {
                throw new RuntimeException("Transaction or operation can't be null");
            }
            OperationHandler handler = operationStrategy.get(transaction.getOperation());
            if (handler == null) {
                throw new RuntimeException(
                        "Not found a handler for operation " + transaction.getOperation());
            }
            handler.handler(transaction, storage);
        }
    }
}
