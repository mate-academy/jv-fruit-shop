package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;

public class SupplyOperationHandler implements OperationHandler {

    public SupplyOperationHandler() {
    }

    @Override
    public void applyOperation(Transaction transaction) {
        String fruit = transaction.getFruit();
        Integer transactionAmount = transaction.getAmount();
        Integer storageAmount = Storage.getFruitAmount(fruit);
        Storage.putFruitToStorage(fruit, storageAmount + transactionAmount);
    }
}
