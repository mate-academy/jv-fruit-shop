package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;

public class BalanceOperationHandler implements OperationHandler {

    public BalanceOperationHandler() {
    }

    @Override
    public void applyOperation(Transaction transaction) {
        String fruit = transaction.getFruit();
        Integer transactionAmount = transaction.getAmount();
        Integer storageAmount = Storage.getFruitAmount(fruit);
        Storage.putFruitToStorage(fruit, storageAmount + transactionAmount);
    }
}
