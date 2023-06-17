package core.basesyntax.strategy.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.Operation;

public class SupplyOperation implements Operation {
    @Override
    public void doOperation(FruitTransaction transaction) {
        int currentQuantity = Storage.storage.get(transaction.getFruit()) != null ?
                Storage.storage.get(transaction.getFruit()) : 0;
        Storage.storage.put(transaction.getFruit(), transaction.getQuantity() + currentQuantity);
    }
}
