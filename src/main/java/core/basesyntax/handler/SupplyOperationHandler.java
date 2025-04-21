package core.basesyntax.handler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void get(FruitTransaction fruitTransaction) {
        int current = Storage.fruitStorage.get(fruitTransaction.getFruit());
        Storage.fruitStorage.put(fruitTransaction.getFruit(), current
                + fruitTransaction.getQuantity());
    }
}
