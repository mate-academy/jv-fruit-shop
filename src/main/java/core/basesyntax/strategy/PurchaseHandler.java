package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int current = Storage.getOrDefault(fruit, 0);
        int newBalance = current - transaction.getQuantity();
        if (newBalance < 0) {
            throw new RuntimeException("There is not enough items to make a purchase");
        }
        Storage.put(fruit, newBalance);
    }
}
