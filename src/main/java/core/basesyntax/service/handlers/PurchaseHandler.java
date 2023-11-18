package core.basesyntax.service.handlers;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.storage.Storage;

public class PurchaseHandler implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction) {
        Integer quantity = Storage.storage.get(transaction.getFruit());
        if (quantity - transaction.getQuantity() < 0) {
            throw new IllegalArgumentException("Amount can`t be less then zero,"
                    + " can`t sell more then we have");
        }
        Storage.storage.put(transaction.getFruit(), quantity - transaction.getQuantity());
    }
}
