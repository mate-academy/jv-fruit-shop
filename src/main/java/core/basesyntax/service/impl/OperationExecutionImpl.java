package core.basesyntax.service.impl;

import core.basesyntax.db.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationExecution;
import core.basesyntax.strategy.OperationStrategy;

public class OperationExecutionImpl implements OperationExecution {
    private final StorageDao storageDao;
    private final OperationStrategy operationStrategy;

    public OperationExecutionImpl(StorageDao storageDao, OperationStrategy operationStrategy) {
        this.storageDao = storageDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void execute(FruitTransaction currentFruitTransaction) {
        if (storageDao.get(currentFruitTransaction.getFruit()) == null) {
            storageDao.add(currentFruitTransaction);
            return;
        }
        FruitTransaction fruitTransactionInStorage = storageDao
                .get(currentFruitTransaction.getFruit());
        int quantity = currentFruitTransaction.getQuantity();
        int operation = operationStrategy
                .get(currentFruitTransaction.getOperation())
                .getOperation(quantity);
        int newQuantity = fruitTransactionInStorage.getQuantity() + operation;
        fruitTransactionInStorage.setQuantity(newQuantity);
    }
}
