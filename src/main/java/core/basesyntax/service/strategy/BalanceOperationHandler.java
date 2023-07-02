package core.basesyntax.service.strategy;

import core.basesyntax.db.StorageImpl;
import core.basesyntax.model.Transaction;

public class BalanceOperationHandler implements OperationHandler {

    public BalanceOperationHandler() {
    }

    @Override
    public void applyOperation(Transaction transaction) {
        String fruit = transaction.getFruit().getFruitName();
        Integer transactionAmount = transaction.getAmount();
        Integer storageAmount = StorageImpl.getFruitAmount(fruit);
        StorageImpl.putFruitToStorage(fruit, storageAmount + transactionAmount);
    }
}
