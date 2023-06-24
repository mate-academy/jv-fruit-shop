package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction transaction) {
        int oldQuantity = Storage.fruitStorage.get(transaction.getFruit());
        Storage.fruitStorage.put(transaction.getFruit(), oldQuantity
                + transaction.getQuantity());
    }
}
