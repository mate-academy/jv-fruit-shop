package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class ReturnOperationImpl implements OperationHandler {
    int MIN_QUANTITY = 0;

    @Override
    public void applyOperation(FruitTransaction transaction) {
        if (transaction.getQuantity() <= MIN_QUANTITY) {
            throw new RuntimeException("You must return 1 or more items. But was: "
                    + transaction.getQuantity());
        }
        Storage.updateDb(transaction.getFruitName(),
                transaction.getQuantity()
                        + Storage.getQuantity(transaction.getFruitName()));
    }
}
