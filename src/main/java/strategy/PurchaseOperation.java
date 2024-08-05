package strategy;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Storage;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Storage storage) {
        storage.decreaseQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
