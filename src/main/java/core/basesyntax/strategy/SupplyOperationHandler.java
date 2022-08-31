package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        int currentQuantity = Storage.getStorage().get(fruit);
        Storage.getStorage().put(fruit, currentQuantity + transaction.getQuantity());
    }
}
