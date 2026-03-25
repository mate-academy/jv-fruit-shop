package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction t) {
        int current = Storage.get(t.getFruit());

        if (current < t.getQuantity()) {
            throw new RuntimeException("Not enough " + t.getFruit()
                    + " in storage. Available: " + current);
        }

        Storage.add(t.getFruit(), -t.getQuantity());
    }
}

