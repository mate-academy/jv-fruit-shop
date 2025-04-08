package core.basesyntax.service.handler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int updatedQuantity = Storage.get(fruit) + transaction.getQuantity();
        Storage.put(fruit, updatedQuantity);
    }
}
