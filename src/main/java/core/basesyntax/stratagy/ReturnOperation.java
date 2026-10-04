package core.basesyntax.stratagy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(final FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int fruitQuantity = transaction.getQuantity();
        Storage.merge(fruit, fruitQuantity);
    }
}
