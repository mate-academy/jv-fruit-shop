package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyHandler implements OperationHendler {
    @Override
    public void operateTransaction(FruitTransaction transaction) {
        int oldQuantity = Storage.fruitStorage.getOrDefault(transaction.getFruit(), 0);
        Storage.fruitStorage.put(transaction.getFruit(), oldQuantity + transaction.getQuantity());
    }
}
