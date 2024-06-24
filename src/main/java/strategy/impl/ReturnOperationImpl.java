package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class ReturnOperationImpl implements OperationHandler {
    private static final int MINIMUM_QUANTITY = 0;

    @Override
    public void applyOperation(FruitTransaction transaction) {
        if (transaction.getQuantity() <= MINIMUM_QUANTITY) {
            throw new RuntimeException("You must return 1 or more items. But was: "
                    + transaction.getQuantity());
        }
        Storage.updateDb(transaction.getFruitName(),
                transaction.getQuantity()
                        + Storage.getQuantity(transaction.getFruitName()));
    }
}
