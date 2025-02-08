package core.basesyntax.services.operations;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.models.Storage;
import core.basesyntax.services.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int currentQuantity = transaction.getQuantity();
        if (Storage.getFruits().containsKey(fruit)) {
            Integer result = Storage.getFruits().get(fruit) + currentQuantity;
            Storage.getFruits().put(fruit, result);
        }
    }
}
