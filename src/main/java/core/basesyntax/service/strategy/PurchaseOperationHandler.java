package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;

public class PurchaseOperationHandler implements OperationHandler {

    public PurchaseOperationHandler() {
    }

    @Override
    public void applyOperation(Transaction transaction) {
        String fruit = transaction.getFruit();
        Integer transactionAmount = transaction.getAmount();
        Integer storageAmount = Storage.getFruitAmount(fruit);
        if (transactionAmount > storageAmount) {
            throw new RuntimeException("Illegal daily report value for "
                    + transaction.getFruit()
                    + ". Total amount is negative.");
        }
        Storage.putFruitToStorage(fruit, storageAmount - transactionAmount);
    }
}
