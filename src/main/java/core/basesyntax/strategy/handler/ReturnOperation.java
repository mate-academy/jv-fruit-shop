package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction transaction) {
        int returnQuantity = transaction.getQuantity();
        if (returnQuantity >= 0) {
            Storage.getFruits().merge(transaction.getFruitName(), returnQuantity, Integer::sum);
        } else {
            throw new IllegalArgumentException("Invalid quantity: " + returnQuantity);
        }
    }
}
