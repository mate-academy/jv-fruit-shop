package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int updatedQuantity = Storage.getQuantity(transaction.getFruit())
                + transaction.getQuantity();
        Storage.put(transaction.getFruit(), updatedQuantity);
    }
}
