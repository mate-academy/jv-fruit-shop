package core.basesyntax.services.handlers.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.exceptions.NegativeResultException;
import core.basesyntax.exceptions.NoSuchFruitFoundException;
import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.handlers.OperationHandler;
import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        Map.Entry<String, Integer> storageEntry =
                Storage.iterateAndFindFruits(fruitTransaction.getFruit());
        if (fruit != null) {
            int fruitQuantityAfterOperation = fruit.getValue() - fruitTransaction.getQuantity();
            if (fruitQuantityAfterOperation < 0) {
                throw new NegativeResultException("Insufficient stock for purchase: Requested " +
                    fruitTransaction.getQuantity() + " but only " +
                    storageEntry.getValue() + " available for " +
                    fruitTransaction.getFruit());
            }
            fruit.setValue(fruitQuantityAfterOperation);
        } else {
            throw new NoSuchFruitFoundException("Can't purchase...No such fruit found...");
        }
    }
}
