package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.TransactionService;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private final OperationStrategy operationStrategy;
    private final StorageDao storage;

    public TransactionServiceImpl(OperationStrategy operationStrategy, StorageDao storage) {
        this.operationStrategy = operationStrategy;
        this.storage = storage;
    }

    @Override
    public void applyTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler operation = operationStrategy.get(transaction.getOperation());
            Fruit fruit = transaction.getFruit();
            if (storage.get(fruit) != null) {
                storage.put(fruit, operation
                        .doOperation(storage.get(fruit), transaction.getQuantity())
                );
                continue;
            }
            storage.put(fruit, operation.doOperation(0, transaction.getQuantity()));
        }
    }
}
