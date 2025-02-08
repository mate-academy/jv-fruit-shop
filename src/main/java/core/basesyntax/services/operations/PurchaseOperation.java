package core.basesyntax.services.operations;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.models.Storage;
import core.basesyntax.services.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        Integer quantity = transaction.getQuantity();
        Integer currentQuantity = Storage.getFruits().getOrDefault(fruit, 0);
        if (Storage.getFruits().containsKey(fruit) && currentQuantity >= quantity) {
            Storage.getFruits().put(fruit, currentQuantity - quantity);
        } else {
            throw new RuntimeException("Not enough fruits: " + fruit + " in storage");
        }
    }
}
