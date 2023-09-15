package core.basesyntax.handlers;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void calculateOperation(FruitTransaction transaction) {
        int returnResult = Storage.STORAGE.get(transaction.getFruit()) + transaction.getQuantity();
        Storage.STORAGE.put(transaction.getFruit(), returnResult);
    }
}
