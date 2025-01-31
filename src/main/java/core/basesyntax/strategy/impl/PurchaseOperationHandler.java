package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private final Storage storage;

    public PurchaseOperationHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        int currentQuantity = storage.getQuantity(transaction.getFruit());
        if (currentQuantity >= transaction.getQuantity()) {
            storage.updateInventory(transaction.getFruit(), -transaction.getQuantity());
        } else {
            throw new RuntimeException("Не вистачає фруктів для купівлі: "
                    + transaction.getFruit());
        }
    }
}
