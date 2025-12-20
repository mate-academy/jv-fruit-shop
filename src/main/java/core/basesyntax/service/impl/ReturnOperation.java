package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperation implements OperationHandler {
    private final Storage storage;

    public ReturnOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        if (!storage.findFruit(fruit)) {
            storage.addFruit(transaction.getFruit(), 0);
        }
        int currentQuantity = storage.getFruitQuantity(fruit);
        int purchaseQuantity = transaction.getQuantity();
        storage.addFruit(fruit, currentQuantity + purchaseQuantity);
    }
}
