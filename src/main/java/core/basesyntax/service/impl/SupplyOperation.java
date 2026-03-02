package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int addedQuantity = transaction.getQuantity();
        int currentQuantity = Storage.getFruitQuantity(fruit);
        Storage.putFruit(fruit, currentQuantity + addedQuantity);
    }
}
