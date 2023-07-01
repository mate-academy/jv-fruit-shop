package core.basesyntax.service.strategy;

import core.basesyntax.db.StorageImpl;
import core.basesyntax.model.Transaction;

public class PurchaseOperationHandler implements OperationHandler {

    public PurchaseOperationHandler() {
    }

    @Override
    public void applyOperation(Transaction transaction) {
        String fruit = transaction.getFruit().getFruitName();
        Integer transactionAmount = transaction.getAmount();
        Integer storageAmount = StorageImpl.getFruitAmount(fruit);
        if (transactionAmount > storageAmount) {
            throw new RuntimeException("Illegal daily report value for "
                    + transaction.getFruit().getFruitName()
                    + ". Total amount is negative.");
        }
        StorageImpl.putFruitToStorage(fruit, storageAmount - transactionAmount);
    }
}
