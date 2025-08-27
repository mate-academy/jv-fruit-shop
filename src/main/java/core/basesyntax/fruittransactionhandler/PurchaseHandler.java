package core.basesyntax.fruittransactionhandler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer oldValue = Storage
                .getDataStorageMap().get(fruitTransaction.getFruit());
        Storage.getDataStorageMap()
                .put(fruitTransaction.getFruit(), 0);
        if (oldValue - fruitTransaction.getQuantity() >= 0) {
            Storage.getDataStorageMap()
                    .put(fruitTransaction.getFruit(), oldValue - fruitTransaction.getQuantity());
        } else {
            throw new RuntimeException("The result of purchase operation is negative.");
        }
    }
}
