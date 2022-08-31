package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.prefs.BackingStoreException;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(Transaction transaction) throws BackingStoreException {
        Fruit fruit = transaction.getFruit();
        Integer currentQuantity = Storage.get(fruit);
        if (currentQuantity - transaction.getQuantity() < 0) {
            throw new BackingStoreException("No such quantity of " + fruit);
        }
        Storage.put(fruit, currentQuantity - transaction.getQuantity());
    }
}
