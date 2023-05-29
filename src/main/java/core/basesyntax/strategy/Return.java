package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class Return implements OperationHandler{
    @Override
    public void operateTransaction(FruitTransaction transaction, Storage storage) {
        int PreviousQuantity = storage.get(transaction.getFruit());
        storage.put(transaction.getFruit(), PreviousQuantity + transaction.getQuantity());
    }
}
