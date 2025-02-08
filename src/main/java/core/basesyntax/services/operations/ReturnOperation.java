package core.basesyntax.services.operations;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.models.Storage;
import core.basesyntax.services.OperationHandler;

public class ReturnOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int quantity = transaction.getQuantity();
        String fruit = transaction.getFruit();
        if (Storage.getFruits().containsKey(fruit)) {
            int result = Storage.getFruits().get(fruit) + quantity;
            Storage.getFruits().put(fruit, result);
        } else {
            Storage.getFruits().put(fruit,quantity);
        }
    }
}
