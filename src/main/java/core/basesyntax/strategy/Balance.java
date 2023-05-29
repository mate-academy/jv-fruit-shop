package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class Balance implements OperationHandler{
    @Override
    public void operateTransaction(FruitTransaction transaction, Storage storage) {
        storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
