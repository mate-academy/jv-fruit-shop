package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        int currentQuantity = Storage.getFruits().getOrDefault(transaction.getFruit(), 0);
        int newBalance = currentQuantity - transaction.getQuantity();
        if (newBalance < 0) {
            throw new RuntimeException("Your balance can't be negative, Balance: " + newBalance);
        }
        Storage.getFruits()
                .put(transaction.getFruit(), newBalance);
    }
}
