package core.basesyntax.service.strategy.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.handler.OperationHandler;

public class SupplyOperation implements OperationHandler {

    @Override
    public void handle(FruitTransaction fruitTransaction, Storage storage) {
        int balance = storage.get(fruitTransaction.getFruit());
        int newBalance = balance + fruitTransaction.getQuantity();
        storage.put(fruitTransaction.getFruit(), newBalance);
    }
}
