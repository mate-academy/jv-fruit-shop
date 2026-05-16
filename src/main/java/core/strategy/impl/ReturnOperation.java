package core.strategy.impl;

import core.db.Storage;
import core.strategy.FruitTransaction;
import core.strategy.OperationHandler;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Storage storage) {
        int currentQuantity = storage.getFruit((transaction.getFruit()));
        storage.setFruit(transaction.getFruit(), currentQuantity + transaction.getQuantity());
    }
}
