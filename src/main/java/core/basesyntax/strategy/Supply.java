package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class Supply implements OperationHandler {
    @Override
    public void operateTransaction(FruitTransaction transaction, Storage storage) {
        int previousQuantity = storage.get(transaction.getFruit());
        storage.put(transaction.getFruit(), previousQuantity + transaction.getQuantity());
    }
}
