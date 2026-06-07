package core.basesyntax.service.strategy.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.handler.OperationHandler;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void handle(FruitTransaction fruitTransaction, Storage storage) {
        int balance = storage.get(fruitTransaction.getFruit());
        int leftover = balance - fruitTransaction.getQuantity();
        storage.put(fruitTransaction.getFruit(), leftover);
    }
}
