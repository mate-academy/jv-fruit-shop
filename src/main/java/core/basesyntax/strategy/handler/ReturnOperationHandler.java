package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    private static final String INVALID_RETURN_QUANTITY = "Invalid return quantity: ";

    @Override
    public void process(FruitTransaction transaction) {
        int returnQuantity = transaction.getQuantity();
        if (returnQuantity >= 0) {
            Storage.fruits.merge(transaction.getFruitName(), returnQuantity, Integer::sum);
        } else {
            throw new IllegalArgumentException(INVALID_RETURN_QUANTITY + returnQuantity);
        }
    }
}
