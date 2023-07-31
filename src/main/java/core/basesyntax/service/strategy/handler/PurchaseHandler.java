package core.basesyntax.service.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void process(FruitTransaction transaction) {
        int fruitsInStorageQuantity = Storage.getStorage().get(transaction.getFruit());
        if (fruitsInStorageQuantity < transaction.getQuantity()) {
            throw new RuntimeException("Can't do purchase operation. Count of fruit \""
                    + transaction.getFruit() + "\" is " + fruitsInStorageQuantity + ". But quantity"
                    + " of current purchase transaction is " + transaction.getQuantity());
        }
        Storage.getStorage().replace(transaction.getFruit(),
                fruitsInStorageQuantity - transaction.getQuantity());
    }
}
