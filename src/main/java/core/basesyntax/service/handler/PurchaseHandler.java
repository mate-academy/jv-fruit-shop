package core.basesyntax.service.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        int result = Storage.fruits.get(transaction.getFruit()) - transaction.getQuantity();
        if (result >= 0) {
            Storage.fruits.put(transaction.getFruit(), result);
        } else {
            throw new RuntimeException("Not enough fruits!");
        }
    }
}
