package core.basesyntax.service.impl;

import core.basesyntax.db.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Executor;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ExecutorImpl implements Executor {
    private final StorageDao storageDao;
    private final OperationStrategy operationStrategy;

    public ExecutorImpl(StorageDao storageDao, OperationStrategy operationStrategy) {
        this.storageDao = storageDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void execute(List<FruitTransaction> fruitTransactionData) {
        for (FruitTransaction fruitTransaction : fruitTransactionData) {
            if (storageDao.get(fruitTransaction.getFruit()) == null) {
                storageDao.add(fruitTransaction);
                continue;
            }
            FruitTransaction fruitTransactionInStorage = storageDao
                    .get(fruitTransaction.getFruit());
            int quantity = fruitTransaction.getQuantity();
            int operation = operationStrategy
                    .get(fruitTransaction.getOperation())
                    .getOperation(quantity);
            int newQuantity = fruitTransactionInStorage.getQuantity() + operation;
            fruitTransactionInStorage.setQuantity(newQuantity);

        }
    }
}
