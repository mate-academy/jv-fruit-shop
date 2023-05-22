package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {

    @Override
    public void operateTransaction(FruitTransaction transaction) {
        Storage storage = new Storage();
        int oldQuantity = storage.get(transaction.getFruit());
        storage.put(transaction.getFruit(), oldQuantity + transaction.getQuantity());
    }
}
