package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final Storage storage;
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(Storage storage, OperationStrategy operationStrategy) {
        this.storage = storage;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new IllegalArgumentException("Transactions cannot be null");
        }
        for (FruitTransaction transaction : transactions) {

            if (transaction == null) {
                throw new IllegalArgumentException("Transaction cannot be null");
            }
            if (transaction.getOperation() == null) {
                throw new IllegalArgumentException("Operation cannot be null");
            }

            OperationHandler operationHandler = operationStrategy.get(transaction.getOperation());
            if (operationHandler == null) {
                throw new RuntimeException("No handler found for operation: "
                        + transaction.getOperation());
            }
            operationHandler.handle(transaction, storage);
        }

    }
}
