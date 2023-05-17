package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SubtractionOperation implements OperationHendler {
    @Override
    public void operateTransaction(FruitTransaction transaction) {
        int oldQuantity = Storage.fruitStorage.get(transaction.getFruit());
        Storage.fruitStorage.put(transaction.getFruit(), oldQuantity - transaction.getQuantity());
    }
}
